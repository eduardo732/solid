package cl.edu.dev.solid.application.mapper

import cl.edu.dev.solid.application.dto.CarDto
import cl.edu.dev.solid.application.dto.RegisterCarDto
import cl.edu.dev.solid.model.Car
import cl.edu.dev.solid.model.Person

object CarMapper {
    fun toDTO(car: Car): CarDto {
        return CarDto(
            car.brand,
            car.model
        )
    }

    fun toEntity(registerCarDto: RegisterCarDto, person: Person?): Car {
        return Car(
            null,
            registerCarDto.brand,
            registerCarDto.model,
            person
        )
    }

    fun toEntityFromDto(carDto: CarDto): Car {
        return Car(
            null,
            carDto.brand,
            carDto.model,
            null
        )
    }
}
