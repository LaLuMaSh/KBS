package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.dto.MovieDto;
import ch.lalumash.kbs.manager.KinoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie/")
@CrossOrigin("*")
public class MovieController {

    private final KinoManager kinoManager;

    @Autowired
    public MovieController(KinoManager kinoManager) {
        this.kinoManager = kinoManager;
    }

    @GetMapping("get")
    public List<MovieDto> getAllMovies() {
        return kinoManager.getAllMovies();
    }
}
