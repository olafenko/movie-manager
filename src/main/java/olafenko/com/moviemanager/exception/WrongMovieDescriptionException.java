package olafenko.com.moviemanager.exception;

public class WrongMovieDescriptionException extends RuntimeException{

    public WrongMovieDescriptionException(String message) {
        super(message);
    }

    public WrongMovieDescriptionException(String message, Throwable cause) {
        super(message, cause);
    }

}
