package cl.edu.dev.solid.application.dto

import lombok.Builder
import lombok.Data

data class ErrorDTO(
    var code: String? = null,
    var message: String? = null
) {

}
