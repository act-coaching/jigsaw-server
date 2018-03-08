package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Team;
import act.coaching.jigsaw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    PersonRepository personRepository;


    @Override
    public List<Team> getTeamList() {
        List<Person> personList = personRepository.findAll();

        return getGroupingTeam(personList);
    }

    private List<Team> getGroupingTeam(List<Person> personList) {

        List<Team> teamList = new ArrayList<>();

        Map<String, Team> teamMap = new HashMap<>();

        int index = 1;
        for(Person p : personList){
            String key = p.getTeam() + p.getDepartment();

            Team team;
            if(!teamMap.containsKey(key)){
                team = new Team();

                team.setId(index++);
                team.setTeam(p.getTeam());
                team.setDepartment(p.getDepartment());

            }else{
                team = teamMap.get(key);
            }


            countTotalNumber(team);
            countAssignTypes(team, p);

            teamMap.put(key, team);
        }

        teamList.addAll(teamMap.values());

        Collections.sort(teamList, (o1, o2) -> {
            if(o1.getId() >= o2.getId()) {
                return 1;
            }else{
                return -1;
            }
        });

        return teamList;
    }

    private void countTotalNumber(Team team) {
        team.setTotalNumber(team.getTotalNumber() + 1);
    }

    private void countAssignTypes(Team team, Person p) {
        switch (p.getAssignType()){
            case "PJT" :
                team.setAssignedNumber(team.getAssignedNumber() + 1);
                break;
            case "과제" :
                team.setUnassignedWorkingNumber(team.getUnassignedWorkingNumber() + 1);
                break;
            default:
                team.setUnassignedNotWorkingNumber(team.getUnassignedNotWorkingNumber() + 1);
                break;
        }
    }


}
