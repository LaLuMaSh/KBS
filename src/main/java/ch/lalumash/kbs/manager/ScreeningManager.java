package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.datastorage.DataProvider;
import ch.lalumash.kbs.dto.LocationDto;
import ch.lalumash.kbs.dto.ReservationDto;
import ch.lalumash.kbs.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningManager {
    private List<Screening> screenings;

    public List<Screening> getScreening(String movie, LocalDate time) {
        throw new RuntimeException("not implemented");
    }

    public void displayInformation(Screening screening) {
        throw new RuntimeException("not implemented");
    }

    public String reservePlace(ReservationDto reservationDto) {
        Customer customer = DataProvider.customers.stream().filter(c -> c.getUuid().equals(reservationDto.customerUuid)).findFirst().orElse(null);

        if (customer == null) {
            return "Der Benutzer existiert nicht.";
        }

        Screening screening = DataProvider.screenings.stream().filter(screening1 -> screening1.getUuid().equals(reservationDto.screeningUuid)).findFirst().orElse(null);

        if (screening == null) {
            return "Die Vorstellung existiert nicht.";
        }

        for (LocationDto locationDto : reservationDto.places) {

            Row row = null;
            Hall hall = screening.getHall();

            if (hall == null) {
               return "Halle wurde nicht gefunden.";
            }

            if (locationDto == null) {
                return "Fehlerhafter zustand";
            }


            List<Row> rows = hall.getRows();
            for (Row r : rows) {

                if (r.getId() == locationDto.getRow()) {
                    row = r;
                    break;
                }
            }

            if (row == null) {
                return "Die Reihe " + locationDto.getRow() + " existiert nicht.";
            }

            Place place = row.getPlaces().stream().filter(place1 -> place1.getNumber() == locationDto.getPlace()).findFirst().orElse(null);

            if (place == null) {
                return "Der Platz " + locationDto.getPlace() + " existiert nicht.";
            }

            Reservation reservation = new Reservation(screening.getUuid(), customer.getUuid());
            place.getReservations().add(reservation);
        }

        return "";
    }

    public List<Customer> getCustomers(Screening screening) {
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
