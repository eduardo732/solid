package cl.edu.dev.solid.presentation

import cl.edu.dev.solid.application.business.FindPerson
import cl.edu.dev.solid.application.business.GetPeople
import cl.edu.dev.solid.application.business.RegisterCar
import cl.edu.dev.solid.application.business.RegisterPerson
import cl.edu.dev.solid.application.dto.PersonDTO
import cl.edu.dev.solid.application.dto.RegisterCarDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/person")
class RegisterPresentation(
    private val findPerson: FindPerson,
    private val getPeople: GetPeople,
    private val registerPerson: RegisterPerson, private val registerCar: RegisterCar
) {
    @GetMapping("{id}")
    fun get(@PathVariable("id") id: Long?): ResponseEntity<PersonDTO> {
        return ResponseEntity(findPerson.byId(id!!), HttpStatus.OK)
    }

    @get:GetMapping
    val all: ResponseEntity<Set<PersonDTO>>
        get() = ResponseEntity(getPeople.findAll(), HttpStatus.OK)

    @PostMapping
    fun register(@RequestBody personDTO: PersonDTO?): ResponseEntity<Long?> {
        return ResponseEntity(registerPerson.save(personDTO!!), HttpStatus.CREATED)
    }

    @PostMapping("/car")
    fun registerCar(@RequestBody registerCarDto: RegisterCarDto?): ResponseEntity<Long?> {
        return ResponseEntity(registerCar.save(registerCarDto!!), HttpStatus.CREATED)
    }
}
