package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.datastorage.DataProvider;
import ch.lalumash.kbs.dto.ComplexScreeningDto;
import ch.lalumash.kbs.dto.ScreeningDto;
import ch.lalumash.kbs.model.Screening;
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
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private List<ScreeningDto> getScreeningsForDate(LocalDate date) {
        String time = date.format(formatter);

        return DataProvider.screenings.stream()
                .filter(screening ->
                        time.equalsIgnoreCase(screening.getTime().format(formatter)))
                .map(ScreeningDto::fromScreening)
                .collect(Collectors.toList());
    }
    @GetMapping("get")
    public List<ScreeningDto> getScreening(@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam LocalDate date, @RequestParam(required = false) String movie) {
        if (movie == null || movie.isEmpty()) {
            return getScreeningsForDate(date);
        }
        String time = date.format(formatter);
        return DataProvider.screenings.stream()
                .filter(screening ->
                        screening.getMovie().getTitle().equalsIgnoreCase(movie)
                        && time.equalsIgnoreCase(screening.getTime().format(formatter))
                )
                .map(ScreeningDto::fromScreening)
                .collect(Collectors.toList());
    }

    @GetMapping("get/complex/{uuid}")
    public ComplexScreeningDto getComplexScreening(@PathVariable UUID uuid) {
        Screening screening = DataProvider.screenings.stream()
                .filter(scr -> scr.getUuid().equals(uuid))
                .findFirst().orElse(null);

        if (screening == null) {
            return null;
        }

        return ComplexScreeningDto.fromScreening(screening);
    }
}
