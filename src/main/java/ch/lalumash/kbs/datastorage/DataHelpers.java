package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataHelpers {
    public static Screening createScreening(String movieTitle, String time, String hallName) {
        LocalDateTime parse = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm"));
        Movie movie1 = DataProvider.movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(movieTitle)).findFirst().get();
        Hall hall = DataProvider.halls.stream().filter(hall1 -> hall1.getId().equalsIgnoreCase(hallName)).findFirst().get();
        return new Screening(UUID.randomUUID(), movie1, hall,parse);
    }
    public static Hall createHall(String id) {
        List<Row> rows = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            rows.add(createRow(i));
        }
        return new Hall(id, rows);
    }
    public static Row createRow(int id) {
        List<Place> places = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            places.add(new Place(i, new ArrayList<>()));
        }
        return new Row(id ,places);
    }
}
