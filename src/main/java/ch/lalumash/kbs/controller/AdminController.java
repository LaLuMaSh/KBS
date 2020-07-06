package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.dto.MovieDto;
import ch.lalumash.kbs.manager.KinoManager;
import ch.lalumash.kbs.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin("*")
public class AdminController {
    private final KinoManager kinoManager;

    @Autowired
    public AdminController(KinoManager kinoManager) {
        this.kinoManager = kinoManager;
    }

    @PostMapping("addMovie")
    public MovieDto addMovie(@RequestBody Movie movie) {
        this.kinoManager.addFilm(movie);
        return MovieDto.fromMovie(movie);
    }
}
