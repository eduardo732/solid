package cl.edu.dev.solid.repository

import cl.edu.dev.solid.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<Person?, Long?> {
    fun existsByDni(dni: String?): Boolean?

    fun findByDni(dniPerson: String?): Optional<Person?>?
}
