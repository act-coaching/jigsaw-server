package act.coaching.jigsaw.service;

import act.coaching.jigsaw.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    }

    @Test
    public void whenPersonServiceCallGetPersonList_thenCallOncePersonRepository_findAll(){
        personService.getPersonList();
        verify(personRepository,times(1)).findAll();
    }

}