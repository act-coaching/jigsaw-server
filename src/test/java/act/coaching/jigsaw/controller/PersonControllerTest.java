package act.coaching.jigsaw.controller;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.service.PersonService;
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
import static org.mockito.Matchers.anyString;
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


        mockMvc.perform(get("http://localhost:8080/dashboard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['id']").value("1"))
                .andExpect(jsonPath("$.data[0]['name']").value("a"))
                .andExpect(jsonPath("$.data[0]['email']").value("a@gmail.com"))
                .andExpect(jsonPath("$.data", hasSize(3)));
        verify(personService, times(1)).getPersonList();
    }


    @Test
    public void whenCallGetPersonsByNameAPI_thenReturnPersonResultList() throws Exception {
        when(personService.getPersonsByName("abc")).thenReturn(Lists.newArrayList(
                new Person(1, "abc", "a@gmail.com", "L2","a","a"),
                new Person(2, "abc", "b@gmail.com", "L3","a","a")));


        mockMvc.perform(get("http://localhost:8080/dashboard/name/abc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['name']").value("abc"))
                .andExpect(jsonPath("$.data[1]['name']").value("abc"))
                .andExpect(jsonPath("$.data", hasSize(2)));
        verify(personService, times(1)).getPersonsByName("abc");
    }
    @Test
    public void whenCallGetPersonsByProjectAPI_thenReturnPersonResultList() throws Exception {
        when(personService.getPersonsByProjectCode(anyString())).thenReturn(Lists.newArrayList(
                new Person(1, "abc", "a@gmail.com", "L2","code_abc","abcc"),
                new Person(2, "abc", "b@gmail.com", "L3","code_abc","abcc")));


        mockMvc.perform(get("http://localhost:8080/dashboard/projectCode/code_abc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0]['projectCode']").value("code_abc"))
                .andExpect(jsonPath("$.data[0]['projectName']").value("abcc"))
                .andExpect(jsonPath("$.data[1]['projectCode']").value("code_abc"))
                .andExpect(jsonPath("$.data[1]['projectName']").value("abcc"))
                .andExpect(jsonPath("$.data", hasSize(2)));
        verify(personService, times(1)).getPersonsByProjectCode("code_abc");
    }

}