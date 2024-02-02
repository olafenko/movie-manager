package olafenko.com.moviemanager.exception;

public class MovieAlreadyExistsException extends RuntimeException{

    public MovieAlreadyExistsException(String message) {
        super(message);
    }
    public MovieAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
