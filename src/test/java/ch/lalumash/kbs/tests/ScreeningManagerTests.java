package ch.lalumash.kbs.tests;

import ch.lalumash.kbs.datastorage.EmptyMemoryDataProvider;
import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.dto.LocationDto;
import ch.lalumash.kbs.dto.ReservationDto;
import ch.lalumash.kbs.manager.ScreeningManager;
import ch.lalumash.kbs.model.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScreeningManagerTests {
    @Test
    public void test() {
        IDataProvider dataProvider = new EmptyMemoryDataProvider();


        List<Place> places = new ArrayList<>();
        Place place1 = new Place(1, new ArrayList<>());
        places.add(place1);
        Place place2 = new Place(2, new ArrayList<>());
        places.add(place2);
        Place place3 = new Place(3, new ArrayList<>());
        places.add(place3);
        List<Row> rows = new ArrayList<>();
        rows.add(new Row(1, places));
        Hall hall = new Hall("C1", rows);
        dataProvider.getHalls().add(hall);

        LocalDateTime from = LocalDateTime.of(2020, 10, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2020, 10, 20, 0, 0, 0);
        Movie ein_film = new Movie("Ein Film", 20.0, from, to);
        dataProvider.getMovies().add(ein_film);

        Screening screening = new Screening(UUID.randomUUID(), ein_film, hall, LocalDateTime.of(2020, 10, 20, 10, 30, 0));
        dataProvider.getScreenings().add(screening);

        Customer customer = new Customer(UUID.randomUUID(), "Hans", "Peter", "aasdasdffdsa");
        dataProvider.getCustomers().add(customer);

        dataProvider.getHalls().add(hall);

        ScreeningManager screeningManager = new ScreeningManager(dataProvider);

        LocationDto[] locations = new LocationDto[2];
        locations[0] = new LocationDto(1, 1);
        locations[1] = new LocationDto(1, 2);
        screeningManager.reservePlace(new ReservationDto(locations, customer.getUuid(), screening.getUuid()));

        assert place1.getReservations().size() == 1;
        assert place2.getReservations().size() == 1;
        assert place3.getReservations().size() == 0;

    }
}
