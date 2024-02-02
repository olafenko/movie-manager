package olafenko.com.moviemanager.service;

import lombok.AllArgsConstructor;
import olafenko.com.moviemanager.exception.MovieAlreadyExistsException;
import olafenko.com.moviemanager.exception.UserNotFoundException;
import olafenko.com.moviemanager.exception.WrongMovieDescriptionException;
import olafenko.com.moviemanager.exception.validation.RuleValidator;
import olafenko.com.moviemanager.models.Movie;
import olafenko.com.moviemanager.repository.MovieRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final RuleValidator validator;

    public ResponseEntity<?> addMovie(Movie movie){
        movie.setMovieCode(UUID.randomUUID().toString());

        if (compareMovies(movie.getTitle())){
            throw new MovieAlreadyExistsException("Movie " + movie.getTitle() + " already exists.");
        } else if (!validator.validate(movie.getDescription())){
            throw new WrongMovieDescriptionException("Max lenght of description is 190 characters.");
        } else {
            movieRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }

    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findMovieById(Long id){
        return movieRepository.findMovieById(id).orElseThrow(() -> new UserNotFoundException("Movie with id" + id + " not found."));
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }

    private boolean compareMovies(String title){
        List<Movie> allMovies = findAllMovies();

        return allMovies.stream()
                .anyMatch(movie -> movie.getTitle().toLowerCase().replace(" ","").equals(title.toLowerCase().replace(" ","")));

    }

}
