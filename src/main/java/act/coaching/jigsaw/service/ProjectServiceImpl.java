package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Project;
import act.coaching.jigsaw.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }
}