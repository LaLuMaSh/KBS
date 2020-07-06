package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.Customer;
import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Screening;

import java.util.List;

public interface IDataProvider {
    void setupMovies();
    void setupScreenings();
    void setupHalls();;
    void setupCustomers();

    List<Movie> getMovies();
    List<Screening> getScreenings();
    List<Hall> getHalls();;
    List<Customer> getCustomers();

    default void setup() {
        setupCustomers();
        setupMovies();
        setupHalls();
        setupScreenings();
    }
}
