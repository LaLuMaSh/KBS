package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public List<Reservation> getReservations() {
        throw new RuntimeException("not implemented");
    }
}
