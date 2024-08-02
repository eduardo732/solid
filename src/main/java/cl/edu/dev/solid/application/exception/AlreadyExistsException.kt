package cl.edu.dev.solid.application.exception

data class AlreadyExistsException( var code: String,override var message: String?) : RuntimeException(
    "Ya se encuentra la persona con dni $message"
)
