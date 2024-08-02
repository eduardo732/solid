package cl.edu.dev.solid.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String? = null,
    var lastName: String? = null,
    var dni: String? = null,
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    var carSet: Set<Car>? = null
) {

}
