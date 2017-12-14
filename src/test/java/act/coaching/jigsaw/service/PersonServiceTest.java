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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
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
    public void setup() {
        MockitoAnnotations.initMocks(this);

        ArrayList<Person> personList = Lists.newArrayList(
                new Person(1, "babc", "a@gmail.com", "L2" , "abc" , "abc"),
                new Person(2, "0abcd", "a@gmail.com", "L2" , "abcd" , "abcd"),
                new Person(3, "dddabc", "a@gmail.com", "L2" , "a" , "a"),
                new Person(4, "abc", "a@gmail.com", "L2" , "ccaa" , "aadc"),
                new Person(5, "abcc", "b@gmail.com", "L3", "abc" , "adec"));


        when(personRepository.findAll()).thenReturn(Lists.newArrayList(
                new Person(1, "a", "a@gmail.com", "L2" , "a" , "a"),
                new Person(2, "b", "b@gmail.com", "L3", "a" , "a"),
                new Person(3, "c", "c@gmail.com", "L5", "a" , "a")));


        when(personRepository.findByNameContainingIgnoreCase("abc")).thenReturn(personList);

        when(personRepository.findByProjectCode("abc")).thenReturn(personList);
    }

    @Test
    public void whenPersonServiceCallGetPersonList_thenCallOncePersonRepository_findAll() {
        personService.getPersonList();
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void whenPersonServiceCallGetPersonList_thenReturnChangedRankString() {
        List<Person> personList = personService.getPersonList();
        assertThat(personList.get(0).getRank(), is("L2(Engineer)"));
        assertThat(personList.get(1).getRank(), is("L3(Senior Engineer)"));
        assertThat(personList.get(2).getRank(), is("L5(Principle Engineer)"));
    }

    @Test
    public void whenPersonServiceCallGetPersonsByName_thenReturnPersonsListWithGivenName() {
        //when
        List<Person> personList = personService.getPersonsByName("abc");

        //then
        assertThat(personList.size(), is(5));
        assertThat(personList, everyItem(hasProperty("name", containsString("abc"))));
    }

    @Test
    public void whenPersonServiceCallGetPersonByName_thenCallOncePersonRepository_findByName() {
        personService.getPersonsByName("abc");
        verify(personRepository, times(1)).findByNameContainingIgnoreCase("abc");
    }

    @Test
    public void whenPersonServiceCallGetPersonsByProjectCode_thenReturnPersonsListWithGivenName() {
        //when
        List<Person> personList = personService.getPersonsByProjectCode("abc");

        //then
        assertThat(personList.size(), is(5));
        assertThat(personList, everyItem(hasProperty("name", containsString("abc"))));
    }

    @Test
    public void whenPersonServiceCallGetPersonByProjectCode_thenCallOncePersonRepository_findByName() {
        personService.getPersonsByProjectCode("abc");
        verify(personRepository, times(1)).findByProjectCode("abc");
    }
}