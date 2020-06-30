package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Place {
    private int number;
    private List<Reservation> reservations;
}
