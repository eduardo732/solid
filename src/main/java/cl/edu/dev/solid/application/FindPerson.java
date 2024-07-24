package cl.edu.dev.solid.application;

import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class FindPerson {
    private final PersonRepository personRepository;

    FindPerson(PersonRepository personRepository ) {
        this.personRepository = personRepository;
    }

    //TODO:add controlleradvice to manage exceptions and here is or throw notFound
    public Person byId(Long id) {
        return this.personRepository.findById(id).orElse(null);
    }
}
