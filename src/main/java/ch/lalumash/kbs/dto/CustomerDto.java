package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class CustomerDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public static CustomerDto fromCustomer(Customer customer) {
        return new CustomerDto(customer.getUuid(), customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber());
    }
}
