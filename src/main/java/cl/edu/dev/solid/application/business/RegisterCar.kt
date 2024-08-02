package cl.edu.dev.solid.application.business

import cl.edu.dev.solid.application.dto.RegisterCarDto
import cl.edu.dev.solid.application.mapper.CarMapper
import cl.edu.dev.solid.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class RegisterCar(private val carRepository: CarRepository, private val findPerson: FindPerson) {
    fun save(registerCarDto: RegisterCarDto): Long? {
        val person = findPerson.byDni(registerCarDto.dniPerson)
        val car = CarMapper.toEntity(registerCarDto, person)
        return carRepository.save(car).id
    }
}
