package cl.edu.dev.solid.srp.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
