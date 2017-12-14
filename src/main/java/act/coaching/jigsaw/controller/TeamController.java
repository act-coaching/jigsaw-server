package act.coaching.jigsaw.controller;

import act.coaching.jigsaw.domain.TransferVO;
import act.coaching.jigsaw.service.TeamService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping("/teams")
    public TransferVO getAll() {
        return new TransferVO(teamService.getAll());
    }

}
