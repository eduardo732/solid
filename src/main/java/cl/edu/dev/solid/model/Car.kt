package cl.edu.dev.solid.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var brand: String? = null,
    var model: String? = null,
    @ManyToOne
    @JoinColumn(name = "person_id")
    var person: Person? = null
) {
}
