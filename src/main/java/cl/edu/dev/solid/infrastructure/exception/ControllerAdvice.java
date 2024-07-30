package cl.edu.dev.solid.infrastructure.exception;

import cl.edu.dev.solid.application.dto.ErrorDTO;
import cl.edu.dev.solid.application.exception.AlreadyExistsException;
import cl.edu.dev.solid.application.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("C-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NotFoundException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> alreadyExistsExceptionHandler(AlreadyExistsException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }
}
