package cl.edu.dev.solid.application.mapper

import cl.edu.dev.solid.application.dto.CarDto
import cl.edu.dev.solid.application.dto.PersonDTO
import cl.edu.dev.solid.model.Car
import cl.edu.dev.solid.model.Person
import java.util.stream.Collectors

object PersonMapper {
    fun toDTO(person: Person): PersonDTO {
        return PersonDTO(
            person.name,
            person.lastName,
            person.dni,
            person.carSet?.stream()
                ?.map { car: Car -> CarMapper.toDTO(car) }
                ?.collect(Collectors.toSet())
        )
    }
    fun toEntity(personDTO: PersonDTO): Person {
        return Person(
            null,
            personDTO.name,
            personDTO.lastName,
            personDTO.dni,
            personDTO.carDtos?.stream()
                ?.map { carDto: CarDto -> CarMapper.toEntityFromDto(carDto) }?.collect(Collectors.toSet())
        )
    }
}
