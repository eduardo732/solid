package cl.edu.dev.solid.application.business

import cl.edu.dev.solid.application.dto.PersonDTO
import cl.edu.dev.solid.application.exception.NotFoundException
import cl.edu.dev.solid.application.mapper.PersonMapper
import cl.edu.dev.solid.model.Person
import cl.edu.dev.solid.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class FindPerson internal constructor(private val personRepository: PersonRepository) {
    fun byId(id: Long): PersonDTO? {
        return personRepository.findById(id)
            .orElseThrow { NotFoundException("C-404", id.toString()) }?.let {
                PersonMapper.toDTO(
                    it
                )
            }
    }

    fun byDni(dniPerson: String?): Person? {
        return personRepository.findByDni(dniPerson)
            ?.orElseThrow { NotFoundException("C-404", dniPerson) }
    }
}
