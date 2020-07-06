package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.dto.CustomerDto;
import ch.lalumash.kbs.dto.MovieDto;
import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Row;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class KinoManager {
    private List<Hall> halls;
    private IDataProvider iDataProvider;

    public KinoManager(IDataProvider iDataProvider) {
        this.iDataProvider = iDataProvider;
    }

    public void addFilm(Movie movie) {
        iDataProvider.getMovies().add(movie);
    }

    public List<MovieDto> getAllMovies() {
        return iDataProvider.getMovies().stream().map(MovieDto::fromMovie).collect(Collectors.toList());
    }
    public List<CustomerDto> getAllCustomers() {
        return iDataProvider.getCustomers()
                .stream()
                .map(CustomerDto::fromCustomer)
                .collect(Collectors.toList());
    }

    public void createHall(List<Row> rows) {
        throw new RuntimeException("not implemented");
    }
}
