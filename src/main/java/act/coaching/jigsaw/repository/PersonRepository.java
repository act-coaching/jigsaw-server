package act.coaching.jigsaw.repository;

import act.coaching.jigsaw.domain.Person;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonRepository extends Repository<Person,Long> {
    List<Person> findAll();
    List<Person> findByNameContainingIgnoreCase(String name);
}
