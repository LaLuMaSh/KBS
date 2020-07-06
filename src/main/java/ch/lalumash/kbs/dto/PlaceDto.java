package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Place;
import ch.lalumash.kbs.model.Reservation;
import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlaceDto {
    private int number;
    private boolean isReserved;

    public static PlaceDto fromPlace(Place place, Screening screening) {
        boolean isReserved = false;
        for (Reservation reservation : place.getReservations()) {
            if (screening.getUuid().equals(reservation.getScreening().getUuid())) {
                isReserved = true;
            }
        }
        return new PlaceDto(place.getNumber(), isReserved);
    }
}
