package io.localhost.wordrelations.config;

import io.localhost.wordrelations.exception.InverseRelationExistsException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@RestControllerAdvice
@EnableWebMvc
public class DataIntegrityExceptionHandler {

    @ExceptionHandler(value = org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<Object> exception(ConstraintViolationException exception) {
        if (exception.getConstraintName().contains("UNIQUEWORDRELATION")) {
            return new ResponseEntity<>(Map.of("errors", "word relation already exists"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Map.of("errors", "could not create word relation"), HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(value = InverseRelationExistsException.class)
    public ResponseEntity<Object> exception(InverseRelationExistsException exception) {
        return new ResponseEntity<>(Map.of("errors", "inverse word relation already exists"), HttpStatus.BAD_REQUEST);
    }
}
