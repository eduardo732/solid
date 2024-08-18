package cl.edu.dev.solid.application.business.person;

import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.infrastructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPeople {
    private final PersonRepository personRepository;

    GetPeople(PersonRepository personRepository ) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

}
