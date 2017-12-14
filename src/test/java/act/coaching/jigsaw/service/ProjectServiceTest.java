package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.repository.ProjectRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProjectServiceTest {

    @InjectMocks
    ProjectServiceImpl projectService;

    @Mock
    ProjectRepository projectRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(projectRepository.findAll()).thenReturn(Lists.newArrayList(
                new Project("DevProj", "prj123", 3, 0, 2, 1),
                new Project("StgProj", "prj134", 4, 1, 2, 1),
                new Project("RealProj", "prj200", 5, 1, 2, 2)
               ));
    }

    @Test
    public void whenProjectServiceCallGetProjectList_thenReturnProjectDetail(){
        List<Project> projectList = projectService.getProjectList();
        assertThat(projectList.get(0).getProjectName() , is("DevProj"));
        assertThat(projectList.size(), is(3));
    }
}