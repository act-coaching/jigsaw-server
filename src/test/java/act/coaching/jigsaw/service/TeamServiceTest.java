package act.coaching.jigsaw.service;


import act.coaching.jigsaw.domain.Team;
import act.coaching.jigsaw.repository.TeamRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    private Team firstTeam;
    private Team secondTeam;

    @Before
    public void setUp() throws Exception {

        firstTeam = new Team(1, "A Team", "A Group", 9, 1, 3, 5);
        secondTeam = new Team(2, "B Team", "A Group", 10, 0, 10, 0);
    }
    @Test
    public void whenTeamService_thenCallgetAll() throws Exception {
        teamService.getAll();
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    public void whenTeamServiceCallGetAll_thenTeamsCount() throws Exception {
        //given
        List<Team> foundTeamList = Lists.newArrayList(firstTeam, secondTeam);
        when(teamRepository.findAll()).thenReturn(foundTeamList);

        //when
        List<Team> teamList = teamService.getAll();

        //then
        assertThat(teamList.size(), is(2));
    }
}

