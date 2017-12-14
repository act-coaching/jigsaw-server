package act.coaching.jigsaw.controller;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Team;
import act.coaching.jigsaw.domain.TransferVO;
import act.coaching.jigsaw.service.TeamService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class TeamControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamService mockTeamService;

    private Team firstTeam;
    private Team secondTeam;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();

        firstTeam = new Team("A Team", "A Group", 9, 1, 3, 5);
        secondTeam = new Team("B Team", "A Group", 10, 0, 10, 0);
    }

    @Test
    public void whenCallGetTeamAPI_thenCallTeamServiceGetAll_withTeamId() throws Exception {
        teamController.getAll();

        then(mockTeamService).should(times(1)).getAll();
    }

    @Test
    public void whenCallGetTeamAPI_thenReturnTeamList() throws Exception {
        List<Team> foundTeamList = Lists.newArrayList(firstTeam, secondTeam);
        when(mockTeamService.getAll()).thenReturn(foundTeamList);

        //when
        TransferVO result = teamController.getAll();

        //then
        assertThat(result.getData().size(), is(2));
        assertThat(result.getData().get(0), is(firstTeam));
        assertThat(result.getData().get(1), is(secondTeam));
    }

    @Test
    public void whenCallGetTeamAPI_functionTest() throws Exception {
        when(mockTeamService.getAll()).thenReturn(Lists.newArrayList(firstTeam, secondTeam));

        mockMvc.perform(get("http://localhost:8080/teams"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize((2))))
                .andExpect(jsonPath("$.data[0]['team']").value("A Team"))
                .andExpect(jsonPath("$.data[0]['department']").value("A Group"))
                .andExpect(jsonPath("$.data[0]['totalCount']").value(9))
                .andExpect(jsonPath("$.data[0]['earning']").value("1"))
                .andExpect(jsonPath("$.data[0]['working']").value("3"))
                .andExpect(jsonPath("$.data[0]['staying']").value("5"))
                .andExpect(jsonPath("$.data[1]['team']").value("B Team"))
                .andExpect(jsonPath("$.data[1]['department']").value("A Group"))
                .andExpect(jsonPath("$.data[1]['totalCount']").value(10))
                .andExpect(jsonPath("$.data[1]['earning']").value("0"))
                .andExpect(jsonPath("$.data[1]['working']").value("10"))
                .andExpect(jsonPath("$.data[1]['staying']").value("0"));

    }
}