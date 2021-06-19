package lk.bigzkoop.rocketman.advisors;

import lk.bigzkoop.rocketman.exceptions.NotFoundException;
import lk.bigzkoop.rocketman.exceptions.ValidationException;
import lk.bigzkoop.rocketman.util.StandardDataFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideAdvisor {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardDataFormat> handleNotFoundException(NotFoundException e){

        return new ResponseEntity<>(
                new StandardDataFormat("error", "Data not found", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardDataFormat> handleValidationException(ValidationException e){

        return new ResponseEntity<>(
                new StandardDataFormat("error", "validation error", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardDataFormat> handleException(Exception e){

        return new ResponseEntity<>(
                new StandardDataFormat("error", "Error occurred", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
