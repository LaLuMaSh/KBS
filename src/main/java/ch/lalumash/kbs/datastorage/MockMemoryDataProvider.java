package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static ch.lalumash.kbs.datastorage.MockDataHelpers.createHall;

@Getter
public class MockMemoryDataProvider implements IDataProvider {
    private final List<Movie> movies = new ArrayList<>();
    private final List<Screening> screenings = new ArrayList<>();
    private final List<Hall> halls = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();


    public MockMemoryDataProvider() {
        setup();
    }

    public void setupCustomers() {
        customers.add(new Customer(UUID.randomUUID(),"Hans", "Peter", "31546546546"));
        customers.add(new Customer(UUID.randomUUID(),"Shawn", "Keller", "asfsad"));
        customers.add(new Customer(UUID.randomUUID(),"Max", "Nell", "asdfasdfasdf"));
        customers.add(new Customer(UUID.randomUUID(),"Luca", "Guettinger", "sadfasdfasdf"));
        customers.add(new Customer(UUID.randomUUID(),"Laurin", "Kuezler", "sdfsafdasdf"));
    }

    public void setupMovies() {
        LocalDateTime from = LocalDateTime.of(2020, 10, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2020, 10, 20, 0, 0, 0);
        movies.add(new Movie("Ein Film", 20.0, from, to));
        movies.add(new Movie("Ein Film 2", 30.0,from, to.plusDays(10)));
    }

    public void setupHalls() {
        halls.add(createHall("C-1", 10, 20));
        halls.add(createHall("C-2", 10, 15));
        halls.add(createHall("C-3", 8, 20));
        halls.add(createHall("C-4", 5, 30));
        halls.add(createHall("C-5", 20, 10));
    }

    public void setupScreenings() {
        screenings.add(createScreening("Ein Film", "01-07-2020-10:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "01-07-2020-11:30","C-2"));
        screenings.add(createScreening("Ein Film", "02-07-2020-12:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "02-07-2020-13:30","C-2"));
        screenings.add(createScreening("Ein Film", "03-07-2020-14:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "03-07-2020-15:30","C-2"));
        screenings.add(createScreening("Ein Film", "04-07-2020-16:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "04-07-2020-17:30","C-2"));
        screenings.add(createScreening("Ein Film", "05-07-2020-18:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "05-07-2020-19:30","C-2"));
        screenings.add(createScreening("Ein Film", "06-07-2020-18:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "06-07-2020-19:30","C-2"));
        screenings.add(createScreening("Ein Film", "07-07-2020-18:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "07-07-2020-19:30","C-2"));
        screenings.add(createScreening("Ein Film", "08-07-2020-18:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "08-07-2020-19:30","C-2"));
        screenings.add(createScreening("Ein Film", "09-07-2020-18:30","C-1"));
        screenings.add(createScreening("Ein Film 2", "09-07-2020-19:30","C-2"));
    }
    private Screening createScreening(String movieTitle, String time, String hallName) {
        LocalDateTime parse = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm"));
        Movie movie1 = movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(movieTitle)).findFirst().get();
        Hall hall = halls.stream().filter(hall1 -> hall1.getId().equalsIgnoreCase(hallName)).findFirst().get();
        return new Screening(UUID.randomUUID(), movie1, hall,parse);
    }
}
