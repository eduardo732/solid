package cl.edu.dev.solid.presentation;

import cl.edu.dev.solid.application.FindPerson;
import cl.edu.dev.solid.application.GetAllPersons;
import cl.edu.dev.solid.application.RegisterPerson;
import cl.edu.dev.solid.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonPresentation {
    private final FindPerson findPerson;
    private final GetAllPersons getAllPersons;
    private final RegisterPerson registerPerson;

    public PersonPresentation(
            FindPerson findPerson,
            GetAllPersons getAllPersons,
            RegisterPerson registerPerson
    ) {
        this.findPerson = findPerson;
        this.getAllPersons = getAllPersons;
        this.registerPerson = registerPerson;
    }

    @GetMapping("{id}")
    public Person get(@PathVariable("id") Long id) {
        return this.findPerson.byId(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return this.getAllPersons.findAll();
    }

    @PostMapping
    public Long register(@RequestBody Person person) {
        return this.registerPerson.save(person);
    }
}
