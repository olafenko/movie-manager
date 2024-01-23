package olafenko.com.moviemanager.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String title;
    private String description;
    private String direction;
    private String scenario;
    private String genre;
    private String production;
    private LocalDateTime premiere;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String movieCode;

    public Movie(String title, String description, String direction, String scenario, String genre, String production, LocalDateTime premiere, String imageUrl, String movieCode) {
        this.title = title;
        this.description = description;
        this.direction = direction;
        this.scenario = scenario;
        this.genre = genre;
        this.production = production;
        this.premiere = premiere;
        this.imageUrl = imageUrl;
        this.movieCode = movieCode;
    }

}
