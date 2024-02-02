package olafenko.com.moviemanager.exception.validation;

public class MaxLenghtRule implements ValidationRule{

    final int MAX_LENGTH = 190;
    @Override
    public boolean validate(String s) {
        return s.length()<=190;
    }
}
