package olafenko.com.moviemanager.controller;

import lombok.AllArgsConstructor;
import olafenko.com.moviemanager.models.Movie;
import olafenko.com.moviemanager.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> allMovies = movieService.findAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id){
        Movie movieById = movieService.findMovieById(id);
        return new ResponseEntity<>(movieById, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
