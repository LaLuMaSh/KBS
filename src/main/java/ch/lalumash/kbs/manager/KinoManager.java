package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.dto.CustomerDto;
import ch.lalumash.kbs.dto.MovieDto;
import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Row;
import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    /**
     * @param movieTitle the movie that should be used as a screening
     * @param weeks the amount of weeks the screening should run
     * @param start the first date
     * @param time  of the screening in the format hh:mm
     */
    public String createScreenings(String movieTitle, int weeks, LocalDateTime start, String... time) {
        Movie movie = iDataProvider.getMovies().stream().filter(movie1 -> movie1.getTitle().equalsIgnoreCase(movieTitle)).findFirst().orElse(null);

        if (movie == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Film " + movieTitle + " existiert nicht");
        }

        List<LocalTime> times = new ArrayList<>();
        for (String s1 : time) {
            times.add(LocalTime.parse(s1, DateTimeFormatter.ofPattern("HH:mm")));
        }

        List<Hall> halls = iDataProvider.getHalls();

        int createdCount = 0;
        int currentHallIndex = 0;
        for (int i = 0; i < weeks * 7; i++) {
            for (LocalTime localTime : times) {
                LocalDateTime newTime = start.plusDays(i);
                newTime = newTime.withHour(localTime.getHour());
                newTime = newTime.withMinute(localTime.getMinute());

                Screening screening = new Screening(UUID.randomUUID(), movie, halls.get(currentHallIndex), newTime);

                if (currentHallIndex+1 >= halls.size()) {
                    currentHallIndex = 0;
                }else {
                    currentHallIndex++;
                }

                iDataProvider.getScreenings().add(screening);
                createdCount++;
            }
        }
        return "Es wurden " + createdCount + " Vorstellungen erstellt.";
    }
}
