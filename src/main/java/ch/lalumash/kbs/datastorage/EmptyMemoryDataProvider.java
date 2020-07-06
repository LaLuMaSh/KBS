package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.Customer;
import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Movie;
import ch.lalumash.kbs.model.Screening;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EmptyMemoryDataProvider implements IDataProvider {
    private final List<Movie> movies = new ArrayList<>();
    private final List<Screening> screenings = new ArrayList<>();
    private final List<Hall> halls = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void setupMovies() {

    }

    @Override
    public void setupScreenings() {

    }

    @Override
    public void setupHalls() {

    }

    @Override
    public void setupCustomers() {

    }
}
