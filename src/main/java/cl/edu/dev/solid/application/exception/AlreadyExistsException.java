package cl.edu.dev.solid.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlreadyExistsException extends RuntimeException {
    private String code;
    public AlreadyExistsException(String code, long id) {
        super(
                new StringBuilder("La persona con id: ")
                .append(id)
                .append(" ya se encuentra registrada").toString()
        );
        this.code = code;
    }
}
