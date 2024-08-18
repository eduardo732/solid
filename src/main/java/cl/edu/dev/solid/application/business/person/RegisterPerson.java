package cl.edu.dev.solid.application.business.person;

import cl.edu.dev.solid.application.exception.AlreadyExistsException;
import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.infrastructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterPerson {
    private final PersonRepository personRepository;

    public RegisterPerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Long save(Person person) {
        isPersonAlreadyExists(person);
        return this.personRepository.save(person).getId();
    }

    private void isPersonAlreadyExists(Person person) throws AlreadyExistsException {
        if(this.personRepository.existsById(person.getId()))
            throw new AlreadyExistsException("C-409", person.getId());
    }
}
