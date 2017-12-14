package act.coaching.jigsaw.repository;

import act.coaching.jigsaw.domain.Project;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProjectRepository extends Repository<Project,Long> {
    List<Project> findAll();
}
