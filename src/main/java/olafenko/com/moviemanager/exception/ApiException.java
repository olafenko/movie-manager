package olafenko.com.moviemanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter

public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime time;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime time) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }
}
