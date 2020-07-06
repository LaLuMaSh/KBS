package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static ch.lalumash.kbs.datastorage.DataHelpers.createHall;
import static ch.lalumash.kbs.datastorage.DataHelpers.createScreening;

public class DataProvider {
    public static List<Movie> movies = new ArrayList<>();
    public static List<Screening> screenings = new ArrayList<>();
    public static List<Hall> halls = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();


    static {
        halls();
        customers();
        movies();
        screenings();
    }

    private static void customers() {
        customers.add(new Customer(UUID.randomUUID(),"Hans", "Peter", "31546546546"));
        customers.add(new Customer(UUID.randomUUID(),"Shawn", "Keller", "asfsad"));
        customers.add(new Customer(UUID.randomUUID(),"Max", "Nell", "asdfasdfasdf"));
        customers.add(new Customer(UUID.randomUUID(),"Luca", "Guettinger", "sadfasdfasdf"));
        customers.add(new Customer(UUID.randomUUID(),"Laurin", "Kuezler", "sdfsafdasdf"));
    }

    private static void movies() {
        LocalDateTime from = LocalDateTime.of(2020, 10, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2020, 10, 20, 0, 0, 0);
        movies.add(new Movie("Ein Film", 20.0, from, to));
        movies.add(new Movie("Ein Film 2", 30.0,from, to.plusDays(10)));
    }

    private static void halls() {
        halls.add(createHall("C-1"));
        halls.add(createHall("C-2"));
        halls.add(createHall("C-3"));
        halls.add(createHall("C-4"));
        halls.add(createHall("C-5"));
    }

    private static void screenings() {
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
    }
}
