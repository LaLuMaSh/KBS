package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Reservation {
    private Screening screening;
    private Customer customer;
    private List<Place> places;
}
