package cl.edu.dev.solid.presentation;

import cl.edu.dev.solid.application.business.person.FindPerson;
import cl.edu.dev.solid.application.business.person.GetPeople;
import cl.edu.dev.solid.application.business.person.RegisterPerson;
import cl.edu.dev.solid.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonPresentation {
    private final FindPerson findPerson;
    private final GetPeople getPeople;
    private final RegisterPerson registerPerson;

    public PersonPresentation(
            FindPerson findPerson,
            GetPeople getPeople,
            RegisterPerson registerPerson
    ) {
        this.findPerson = findPerson;
        this.getPeople = getPeople;
        this.registerPerson = registerPerson;
    }

    @GetMapping("{id}")
    public Person get(@PathVariable("id") Long id) {
        return this.findPerson.byId(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return this.getPeople.findAll();
    }

    @PostMapping
    public Long register(@RequestBody Person person) {
        return this.registerPerson.save(person);
    }
}
