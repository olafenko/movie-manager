package olafenko.com.moviemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    HttpStatus conflict = HttpStatus.CONFLICT;
    @ExceptionHandler(value = {MovieAlreadyExistsException.class})
    public ResponseEntity<Object> handleMovieAlreadyExistsException(MovieAlreadyExistsException e){


        ApiException exception = new ApiException(e.getMessage(), conflict, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(exception, conflict);
    }

    public ResponseEntity<Object> handleWrongMovieDescriptionException(WrongMovieDescriptionException e){
        ApiException exception = new ApiException(e.getMessage(), conflict, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(exception,conflict );
    }



}
