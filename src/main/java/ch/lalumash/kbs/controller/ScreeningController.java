package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.datastorage.IDataProvider;
import ch.lalumash.kbs.dto.ComplexScreeningDto;
import ch.lalumash.kbs.dto.ReservationDto;
import ch.lalumash.kbs.dto.ScreeningDto;
import ch.lalumash.kbs.manager.ScreeningManager;
import ch.lalumash.kbs.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/screening/")
@CrossOrigin("*")
public class ScreeningController {


    private final ScreeningManager screeningManager;

    @Autowired
    public ScreeningController(ScreeningManager screeningManager) {
        this.screeningManager = screeningManager;
    }



    @GetMapping("get")
    public List<ScreeningDto> getScreening(@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam LocalDate date, @RequestParam(required = false) String movie) {
        return screeningManager.getScreening(movie, date);
    }

    @GetMapping("get/complex/{uuid}")
    public ComplexScreeningDto getComplexScreening(@PathVariable UUID uuid) {
        return this.screeningManager.getDetails(uuid);
    }
    @GetMapping("get/customer/{uuid}")
    public List<ScreeningDto> get(@PathVariable UUID uuid) {
        return this.screeningManager.getScreenings(uuid);
    }

    @PostMapping("reserve/")
    public String reserve(@RequestBody ReservationDto reservationDto) {
        return this.screeningManager.reservePlace(reservationDto);
    }
}
