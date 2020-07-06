package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.datastorage.DataProvider;
import ch.lalumash.kbs.dto.CustomerDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customer/")
@CrossOrigin("*")
public class CustomerController {
    @GetMapping("get")
    public List<CustomerDto> getAll() {
        return DataProvider.customers
                .stream()
                .map(CustomerDto::fromCustomer)
                .collect(Collectors.toList());
    }
}
