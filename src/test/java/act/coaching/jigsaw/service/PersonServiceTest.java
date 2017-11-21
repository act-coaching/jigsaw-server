package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Person;
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
public class PersonServiceTest {

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonRepository personRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(personRepository.findAll()).thenReturn(Lists.newArrayList(
                new Person(1, "a", "a@gmail.com", "L2"),
                new Person(2, "b", "b@gmail.com", "L3"),
                new Person(3, "c", "c@gmail.com", "L5")));
    }

    @Test
    public void whenPersonServiceCallGetPersonList_thenCallOncePersonRepository_findAll(){
        personService.getPersonList();
        verify(personRepository,times(1)).findAll();
    }

    @Test
    public void whenPersonServiceCallGetPersonList_thenReturnChangedRankString(){
        List<Person> personList = personService.getPersonList();
        assertThat(personList.get(0).getRank(), is("L2(Engineer)"));
        assertThat(personList.get(1).getRank(), is("L3(Senior Engineer)"));
        assertThat(personList.get(2).getRank(), is("L5(Principle Engineer)"));

    }

}