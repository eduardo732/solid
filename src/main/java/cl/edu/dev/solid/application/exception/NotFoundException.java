package cl.edu.dev.solid.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RuntimeException {
    private String code;
    public NotFoundException(String code, Long id) {
        super(
                new StringBuilder("No se encontró la persona con identificador: ")
                .append(id).toString()
        );
        this.code = code;
    }
}
