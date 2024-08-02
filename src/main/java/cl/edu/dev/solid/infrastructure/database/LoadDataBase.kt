package cl.edu.dev.solid.infrastructure.database

import cl.edu.dev.solid.model.Person
import cl.edu.dev.solid.repository.PersonRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDataBase {
    @Bean
    fun initDataBase(repository: PersonRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading {}", repository.save(Person(1L, "Rocky", "Balboa", "00.000.000-0", HashSet())))
            log.info("Preloading {}", repository.save(Person(2L, "Blue", "Balboa", "00.000.000-1", HashSet())))
            log.info("Preloading {}", repository.save(Person(3L, "Jhony", "Balboa", "00.000.000-2", HashSet())))
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(LoadDataBase::class.java)
    }
}
