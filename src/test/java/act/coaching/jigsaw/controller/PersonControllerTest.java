package act.coaching.jigsaw.controller;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.service.PersonService;
import act.coaching.jigsaw.service.ProjectService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
public class PersonControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Mock
    private PersonService personService;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void whenCallGetPersonsAPI_thenReturnPersonList() throws Exception {
        when(personService.getPersonList()).thenReturn(Lists.newArrayList(
                new Person(1, "a", "a@gmail.com"),
                new Person(2, "b", "b@gmail.com"),
                new Person(3, "c", "c@gmail.com")));


        mockMvc.perform(get("http://localhost:8080/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['id']").value("1"))
                .andExpect(jsonPath("$.data[0]['name']").value("a"))
                .andExpect(jsonPath("$.data[0]['email']").value("a@gmail.com"))
                .andExpect(jsonPath("$.data", hasSize(3)));
        verify(personService, times(1)).getPersonList();
    }

    @Test
    public void whenCallGetProjectsAPI_thenReturnProjectsList() throws Exception{

        when(projectService.getProjectsList()).thenReturn(Lists.newArrayList(
                new Project(1,"P0001", "ABC Project", 10, 5, 1, 2)
                ,new Project(2,"P0002", "DEF Project", 11, 5, 1, 2)
                ,new Project(3,"P0003", "GHT Project", 12, 5, 1, 2)));

        mockMvc.perform(get("http://localhost:8080/projects"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['id']").value("1"))
                .andExpect(jsonPath("$.data[0]['projectCode']").value("P0001"))
                .andExpect(jsonPath("$.data[0]['projectName']").value("ABC Project"))
                .andExpect(jsonPath("$.data[0]['totalCnt']").value(10))
                .andExpect(jsonPath("$.data[0]['pmCnt']").value(5))
                .andExpect(jsonPath("$.data[0]['devCnt']").value(1))
                .andExpect(jsonPath("$.data[0]['cxCnt']").value(2))
                .andExpect(jsonPath("$.data", hasSize(3)));
        verify(projectService, times(1)).getProjectsList();

    }

}