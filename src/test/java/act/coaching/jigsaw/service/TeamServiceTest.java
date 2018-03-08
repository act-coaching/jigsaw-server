package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Team;
import act.coaching.jigsaw.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TeamServiceTest {

    @InjectMocks
    TeamServiceImpl teamService;

    @Mock
    PersonRepository personRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(personRepository.findAll()).thenReturn(Lists.newArrayList(
                new Person(1, "cat", "ICTO개발팀", "전자개발그룹", "보직간부"),
                new Person(2, "cat","ICTO개발팀", "전자개발그룹", "PJT"),
                new Person(3, "cat","ICTO개발팀", "전자개발그룹", "과제"),
                new Person(4, "cat","ICTO개발팀", "전자개발그룹", "투입예정"),
                new Person(5, "cat","ICTO개발팀", "전자개발그룹", "타부서지원"),
                new Person(6, "cat","ICTO개발팀", "전자개발그룹", "스탭"),
                new Person(7, "cat","ICTO개발팀1", "전자개발그룹", "보직간부"),
                new Person(8, "cat","ICTO개발팀1", "전자개발그룹", "PJT"),
                new Person(9, "cat","ICTO개발팀1", "전자개발그룹", "과제"),
                new Person(10, "cat","ICTO개발팀1", "전자개발그룹", "투입예정"),
                new Person(11, "cat","ICTO개발팀1", "전자개발그룹", "타부서지원"),
                new Person(12, "cat","ICTO개발팀1", "전자개발그룹", "스탭"),
                new Person(13, "cat","ICTO개발팀1", "전자개발그룹2", "PJT"),
                new Person(14, "cat","ICTO개발팀1", "전자개발그룹2", "과제"),
                new Person(15, "cat","ICTO개발팀1", "전자개발그룹2", "스탭"),
                new Person(16, "cat","ICTO개발팀1", "전자개발그룹2", "스탭"),
                new Person(17, "cat","ICTO개발팀1", "전자개발그룹2", "스탭"),
                new Person(18, "cat","ICTO개발팀1", "전자개발그룹2", "스탭")
                ));
    }

    @Test
    public void teamService에서_getTeamList를_호출했을때_PersonRepository의_findAll을_한번호출한다(){
        teamService.getTeamList();
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void teamService에서_getTeamList를_호출했을때_getGroupingTeam을_반환한다(){
        List<Team> teamList = teamService.getTeamList();
        assertEquals(6, teamList.get(0).getTotalNumber());
        assertEquals(6, teamList.get(1).getTotalNumber());
        assertEquals(6, teamList.get(2).getTotalNumber());

        assertEquals(1, teamList.get(0).getAssignedNumber());
        assertEquals(1, teamList.get(1).getAssignedNumber());
        assertEquals(1, teamList.get(2).getAssignedNumber());

        assertEquals(1, teamList.get(0).getUnassignedWorkingNumber());
        assertEquals(1, teamList.get(1).getUnassignedWorkingNumber());
        assertEquals(1, teamList.get(2).getUnassignedWorkingNumber());

        assertEquals(4, teamList.get(0).getUnassignedNotWorkingNumber());
        assertEquals(4, teamList.get(1).getUnassignedNotWorkingNumber());
        assertEquals(4, teamList.get(2).getUnassignedNotWorkingNumber());

    }

    @Test
    public void teamService에서_getTeamList를_호출했을때_반환된getGroupingTeam값중_가득_비가득_가동의_합은_총원과같다() {
        List<Team> teamList = teamService.getTeamList();
        assertEquals(teamList.get(0).getTotalNumber(), teamList.get(0).getAssignedNumber()
         + teamList.get(0).getUnassignedWorkingNumber() + teamList.get(0).getUnassignedNotWorkingNumber());
    }

}
