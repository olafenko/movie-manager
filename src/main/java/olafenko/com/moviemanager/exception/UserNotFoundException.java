package olafenko.com.moviemanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
            super(message);
    }
}
