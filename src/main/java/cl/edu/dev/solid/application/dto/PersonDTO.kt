package cl.edu.dev.solid.application.dto

data class PersonDTO(
    var name: String? = null,
    var lastName: String? = null,
    var dni: String? = null,
    var carDtos: Set<CarDto>? = null
) {

}
