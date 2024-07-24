package cl.edu.dev.solid.application;

import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterPerson {
    private final PersonRepository personRepository;

    public RegisterPerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Long save(Person person) {
        return this.personRepository.save(person).getId();
    }
}
