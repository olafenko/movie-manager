package olafenko.com.moviemanager.service;

import lombok.AllArgsConstructor;
import olafenko.com.moviemanager.exception.UserNotFoundException;
import olafenko.com.moviemanager.models.Movie;
import olafenko.com.moviemanager.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        movie.setMovieCode(UUID.randomUUID().toString());
        return movieRepository.save(movie);
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

}
