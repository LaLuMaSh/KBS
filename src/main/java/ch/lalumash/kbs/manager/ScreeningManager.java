package ch.lalumash.kbs.manager;

import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.dto.ComplexScreeningDto;
import ch.lalumash.kbs.dto.LocationDto;
import ch.lalumash.kbs.dto.ReservationDto;
import ch.lalumash.kbs.dto.ScreeningDto;
import ch.lalumash.kbs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ScreeningManager {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final IDataProvider iDataProvider;

    @Autowired
    public ScreeningManager(IDataProvider dataProvider) {
        this.iDataProvider = dataProvider;
    }

    public List<ScreeningDto> getScreening(String movie, LocalDate date) {
        String time = date.format(formatter);
        return iDataProvider.getScreenings().stream()
                .filter(screening -> {
                            if (movie == null || movie.isEmpty()) {
                                return time.equalsIgnoreCase(screening.getTime().format(formatter));
                            } else {

                                return screening.getMovie().getTitle().equalsIgnoreCase(movie)
                                        && time.equalsIgnoreCase(screening.getTime().format(formatter));
                            }
                        }
                )
                .map(ScreeningDto::fromScreening)
                .collect(Collectors.toList());
    }

    public ComplexScreeningDto getDetails(UUID uuid) {
        Screening screening = iDataProvider.getScreenings().stream()
                .filter(scr -> scr.getUuid().equals(uuid))
                .findFirst().orElse(null);

        if (screening == null) {
            return null;
        }
        return ComplexScreeningDto.fromScreening(screening);
    }

    public String reservePlace(ReservationDto reservationDto) {
        Customer customer = iDataProvider.getCustomers().stream().filter(c -> c.getUuid().equals(reservationDto.customerUuid)).findFirst().orElse(null);

        if (customer == null) {
            return "Der Benutzer existiert nicht.";
        }

        Screening screening = iDataProvider.getScreenings().stream().filter(screening1 -> screening1.getUuid().equals(reservationDto.screeningUuid)).findFirst().orElse(null);

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

    public List<ScreeningDto> getScreenings(UUID customerId) {
        Customer customer = iDataProvider.getCustomers().stream().filter(c -> c.getUuid().equals(customerId)).findFirst().orElse(null);

        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Benutzer existiert nicht");
        }

        List<Screening> screenings = new ArrayList<>();
        for (Screening screening : iDataProvider.getScreenings()) {
            for (Row row : screening.getHall().getRows()) {
                for (Place place : row.getPlaces()) {
                    for (Reservation reservation : place.getReservations()) {
                        if (reservation.getCustomer().equals(customer.getUuid()) && reservation.getScreening() == screening.getUuid()) {
                            screenings.add(screening);
                        }
                    }
                }
            }
        }
        return screenings.stream().map(ScreeningDto::fromScreening).collect(Collectors.toList());
    }

    public List<Customer> getCustomers(Screening screening) {
        throw new RuntimeException("not implemented");
    }

}
