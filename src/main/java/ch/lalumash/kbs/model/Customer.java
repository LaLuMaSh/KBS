package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Customer {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public List<Reservation> getReservations() {
        throw new RuntimeException("not implemented");
    }
}
