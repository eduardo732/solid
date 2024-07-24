package cl.edu.dev.solid.config.database;

import cl.edu.dev.solid.model.Person;
import cl.edu.dev.solid.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(PersonRepository repository) {
        return args -> {
            log.info("Preloading {}", repository.save(new Person(1L, "Rocky", "Balboa")));
            log.info("Preloading {}", repository.save(new Person(2L, "Blue", "Balboa")));
            log.info("Preloading {}", repository.save(new Person(3L, "Jhony", "Balboa")));
        };
    }
}
