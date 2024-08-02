package cl.edu.dev.solid.application.business

import cl.edu.dev.solid.application.dto.PersonDTO
import cl.edu.dev.solid.application.exception.AlreadyExistsException
import cl.edu.dev.solid.application.mapper.PersonMapper
import cl.edu.dev.solid.model.Car
import cl.edu.dev.solid.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class RegisterPerson(private val personRepository: PersonRepository) {
    fun save(personDTO: PersonDTO): Long? {
        isPersonAlreadyExists(personDTO)
        val person = PersonMapper.toEntity(personDTO)
        person.carSet!!.forEach(Consumer { car: Car -> car.person = person })
        return personRepository.save(person).id
    }

    @Throws(AlreadyExistsException::class)
    private fun isPersonAlreadyExists(personDTO: PersonDTO) {
        if (personRepository.existsByDni(personDTO.dni) == true) throw AlreadyExistsException("C-409", personDTO.dni)
    }
}
