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
        List<Person> personList = personRepository.findAll();
        getRankString(personList);
        return personList;
    }

    private void getRankString(List<Person> personList) {
        personList.forEach( person ->{
                String rank = person.getRank();
                switch (rank){
                    case "L1" :
                        person.setRank("L1(Engineer)");
                        break;
                    case "L2" :
                        person.setRank("L2(Engineer)");
                        break;
                    case "L3" :
                        person.setRank("L3(Senior Engineer)");
                        break;
                    case "L4" :
                        person.setRank("L4(Senior Engineer)");
                        break;
                    case "L5" :
                        person.setRank("L5(Principle Engineer)");
                        break;
                }
        });
    }

}