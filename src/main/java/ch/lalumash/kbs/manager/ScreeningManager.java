package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.model.Customer;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Place;
import ch.lalumash.kbs.model.Screening;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ScreeningManager {
    private List<Screening> screenings;

    private List<Screening> getScreening(String movie, LocalDate time) {
        throw new RuntimeException("not implemented");
    }

    private void displayInformation(Screening screening) {
        throw new RuntimeException("not implemented");
    }

    private void reservePlace(Screening screening, Place... place) {
        throw new RuntimeException("not implemented");
    }

    private List<Customer> getCustomers(Screening screening) {
        throw new RuntimeException("not implemented");
    }
    /**
     * @param movie the movie that should be used as a screening
     * @param weeks the amount of weeks the screening should run
     * @param start the first date
     * @param time of the screening in the format hh:mm
     */
    public void createScreenings(Movie movie, int weeks, LocalDateTime start, String... time) {
        throw new RuntimeException("not implemented");
    }

}
