package cl.edu.dev.solid.application.business.person;

import cl.edu.dev.solid.application.exception.NotFoundException;
import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.infrastructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class FindPerson {
    private final PersonRepository personRepository;

    FindPerson(PersonRepository personRepository ) {
        this.personRepository = personRepository;
    }

    public Person byId(Long id) {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("C-404", id));
    }
}
