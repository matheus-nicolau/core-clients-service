package github.matheus_nicolau.core_clients.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SaveClientException.class)
    public ResponseEntity<ExceptionModel> saveClientNotFoundException(SaveClientException clientException) {
        ExceptionModel exception = new ExceptionModel(clientException.getClass().getSimpleName(),
                        clientException.getMessage(), ZonedDateTime.now(ZoneId.of("UTC")));

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(ClientNotFindException.class)
    public ResponseEntity<ExceptionModel> clientNotFindException(ClientNotFindException clientException) {
        ExceptionModel exception = new ExceptionModel(clientException.getClass().getSimpleName(),
                        clientException.getMessage(), ZonedDateTime.now(ZoneId.of("UTC")));

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
