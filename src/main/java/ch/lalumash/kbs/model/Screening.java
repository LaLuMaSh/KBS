package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class Screening {
    private Movie movie;
    private Hall hall;
    private LocalDateTime time;

    public List<Reservation> getReservations() {
        throw new RuntimeException("not implemented");
    }
}
