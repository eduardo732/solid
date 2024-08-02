package cl.edu.dev.solid.repository

import cl.edu.dev.solid.model.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car?, Long?>
