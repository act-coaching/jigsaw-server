package act.coaching.jigsaw.controller;

import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.service.ProjectService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class ProjectControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    public void whenCallGetProjectAPI_thenREturnProjectList() throws Exception {
        when(projectService.getProjectList()).thenReturn(Lists.newArrayList(
                new Project("타노스프로젝트", "프로젝트111", 5, 1, 4, 0),
                new Project("미팅프로젝트", "프로젝트112", 100, 5, 90, 5),
                new Project("액트", "프로젝트113", 3,3 ,0, 0)));

        mockMvc.perform(get("http://localhost:8080/project"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['projectName']").value("타노스프로젝트"))
                .andExpect(jsonPath("$.data[0]['totalCount']").value(5))
                .andExpect(jsonPath("$.data", hasSize(3)));
        verify(projectService, times(1)).getProjectList();

    }

}