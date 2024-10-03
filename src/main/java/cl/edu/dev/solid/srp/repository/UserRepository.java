package cl.edu.dev.solid.srp.repository;

import cl.edu.dev.solid.srp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

