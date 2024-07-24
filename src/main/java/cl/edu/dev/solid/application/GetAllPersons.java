package cl.edu.dev.solid.application;

import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPersons {
    private final PersonRepository personRepository;

    GetAllPersons ( PersonRepository personRepository ) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

}
