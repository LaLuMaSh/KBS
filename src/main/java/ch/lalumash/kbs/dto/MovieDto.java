package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MovieDto {
    private String name;
    private double price;

    public static MovieDto fromMovie(Movie movie) {
        return new MovieDto(movie.getTitle(), movie.getPrice());
    }
}
