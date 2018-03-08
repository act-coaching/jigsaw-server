package act.coaching.jigsaw.controller;


import act.coaching.jigsaw.domain.TransferVO;
import act.coaching.jigsaw.service.PersonService;
import act.coaching.jigsaw.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    TeamService teamService;

    @RequestMapping("/persons")
    public TransferVO getPersons(){

        return new TransferVO(personService.getPersonList());
    }

    @RequestMapping("/teams")
    public TransferVO getTeams() {
        return new TransferVO(teamService.getTeamList());
    }

}
