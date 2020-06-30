package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Row;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class KinoManager {
    private List<Hall> halls;

    public void addFilm(Movie movie) {
        throw new RuntimeException("not implemented");
    }

    public void createHall(List<Row> rows) {
        throw new RuntimeException("not implemented");
    }
}
