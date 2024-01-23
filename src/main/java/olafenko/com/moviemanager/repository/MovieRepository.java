package olafenko.com.moviemanager.repository;

import olafenko.com.moviemanager.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


    Optional<Movie> findMovieById(Long id);

}
