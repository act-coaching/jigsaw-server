package act.coaching.jigsaw.controller;


import act.coaching.jigsaw.domain.TransferVO;
import act.coaching.jigsaw.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/project")
    public TransferVO getProjects(){

        return new TransferVO(projectService.getProjectList());
    }



}
