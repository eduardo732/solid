package cl.edu.dev.solid.infrastructure.exception

import cl.edu.dev.solid.application.dto.ErrorDTO
import cl.edu.dev.solid.application.exception.AlreadyExistsException
import cl.edu.dev.solid.application.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(value = [RuntimeException::class])
    fun runtimeExceptionHandler(ex: RuntimeException): ResponseEntity<ErrorDTO> {
        val errorDTO: ErrorDTO = ErrorDTO(
            "C-500",
            ex.message
        )
        return ResponseEntity(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundExceptionHandler(ex: NotFoundException): ResponseEntity<ErrorDTO> {
        val errorDTO: ErrorDTO = ErrorDTO(
            ex.code,
            ex.message
        )
        return ResponseEntity(errorDTO, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [AlreadyExistsException::class])
    fun alreadyExistsExceptionHandler(ex: AlreadyExistsException): ResponseEntity<ErrorDTO> {
        val errorDTO: ErrorDTO = ErrorDTO(
            ex.code,
            ex.message
        )
        return ResponseEntity(errorDTO, HttpStatus.CONFLICT)
    }
}
