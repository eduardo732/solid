package cl.edu.dev.solid.application.exception

data class NotFoundException(var code: String, override var message: String?) : RuntimeException(
    "No se encontró la persona con identificador $message"
)
