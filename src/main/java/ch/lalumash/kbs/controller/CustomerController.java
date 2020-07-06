package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.dto.CustomerDto;
import ch.lalumash.kbs.manager.KinoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer/")
@CrossOrigin("*")
public class CustomerController {
    KinoManager kinoManager;

    @Autowired
    public CustomerController(KinoManager kinoManager) {
        this.kinoManager = kinoManager;
    }

    @GetMapping("get")
    public List<CustomerDto> getAll() {
        return this.kinoManager.getAllCustomers();
    }
}
