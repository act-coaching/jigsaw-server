package act.coaching.jigsaw.repository;

import act.coaching.jigsaw.domain.Team;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TeamRepository extends Repository<Team,Long> {
    List<Team> findAll();
}
