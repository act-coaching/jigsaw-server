package act.coaching.jigsaw.service;

import act.coaching.jigsaw.domain.Person;
import act.coaching.jigsaw.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

}