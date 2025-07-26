package github.matheus_nicolau.core_clients.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SaveClientException.class)
    public ResponseEntity<ExceptionModel> saveClientNotFoundException(SaveClientException clientException) {
        ExceptionModel exception = new ExceptionModel(clientException.getClass().getName(),
                                                              clientException.getMessage(),
                                                                      ZonedDateTime.now());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
