package ch.lalumash.kbs.controller;

import ch.lalumash.kbs.datastorage.DataProvider;
import ch.lalumash.kbs.dto.MovieDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/movie/")
@CrossOrigin("*")
public class MovieController {
    @GetMapping("get")
    public List<MovieDto> getAllMovies() {
        return DataProvider.movies.stream().map(MovieDto::fromMovie).collect(Collectors.toList());
    }
}
