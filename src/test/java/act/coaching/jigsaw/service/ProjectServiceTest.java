package act.coaching.jigsaw.service;


import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProjectServiceTest {

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(personRepository.findAll()).thenReturn(Lists.newArrayList(
                new Person(2, "a", "a@gmail.com", "L3", "ABC Project","P0001", "DEV"),
                new Person(3, "a", "a@gmail.com", "L4", "ABC Project","P0001", "CX"),
                new Person(1, "a", "a@gmail.com", "L2", "ABC Project","P0001", "PM")));

    }

    @Test
    public void whenProjectServiceCallGetProjectList_thenReturnProjects(){
        List<Project> projects = projectService.getProjectsList();

        assertThat(projects.get(0).getProjectName(), is("ABC Project"));
        assertThat(projects.get(0).getTotalCnt(), is(3));
        assertThat(projects.get(0).getPmCnt(), is(1));
        assertThat(projects.get(0).getDevCnt(), is(1));
        assertThat(projects.get(0).getCxCnt(), is(1));

    }

    @Test
    public void whenProjectServiceCallGetProjectList_thenCallOncePersonRepository_findAll(){
        projectService.getProjectsList();
        verify(personRepository,times(1)).findAll();
    }

}
