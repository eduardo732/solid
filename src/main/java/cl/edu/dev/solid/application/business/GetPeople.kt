package cl.edu.dev.solid.application.business

import cl.edu.dev.solid.application.dto.PersonDTO
import cl.edu.dev.solid.application.mapper.PersonMapper
import cl.edu.dev.solid.model.Person
import cl.edu.dev.solid.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GetPeople internal constructor(private val personRepository: PersonRepository) {
    fun findAll(): Set<PersonDTO> {
        return personRepository.findAll().stream().map { person: Person? -> person?.let { PersonMapper.toDTO(it) } }
            .collect(Collectors.toSet())
    }
}
