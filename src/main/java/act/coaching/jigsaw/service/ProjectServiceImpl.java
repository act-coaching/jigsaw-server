package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Project> getProjectsList() {
        Map<String, Project> projectMap = new HashMap<>();

        List<Person> persons = personRepository.findAll();
        Project tmpProject;

        int idx=1;
        for (Person person: persons) {
            int cxCnt=0, pmCnt=0, devCnt=0;
            if(projectMap.containsKey(person.getProjectCode())){
                tmpProject = projectMap.get(person.getProjectCode());
                int totalCnt=tmpProject.getTotalCnt();

                getCnt(person.getDuty(),tmpProject);

                projectMap.get(person.getProjectCode()).setTotalCnt(++totalCnt);
                projectMap.get(person.getProjectCode()).setPmCnt(tmpProject.getPmCnt());
                projectMap.get(person.getProjectCode()).setDevCnt(tmpProject.getDevCnt());
                projectMap.get(person.getProjectCode()).setCxCnt(tmpProject.getCxCnt());

            }else{
                Project project = new Project(idx++, person.getProjectCode(), person.getProjectName(),1,pmCnt, devCnt, cxCnt);
                getCnt(person.getDuty(), project);

                projectMap.put(person.getProjectCode(), project);
            }
        }

        return new ArrayList<>(projectMap.values());
    }

    private void getCnt(String duty, Project tmpProject){
        if("PM".equals(duty)){
            int cnt = tmpProject.getPmCnt();
            tmpProject.setPmCnt(++cnt);
        }else if("DEV".equals(duty)){
            int cnt = tmpProject.getDevCnt();
            tmpProject.setDevCnt(++cnt);
        }else if("CX".equals(duty)){
            int cnt = tmpProject.getCxCnt();
            tmpProject.setCxCnt(++cnt);
        }
    }

}
