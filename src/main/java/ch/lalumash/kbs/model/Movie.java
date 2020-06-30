package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Movie {
    private String title;
    private double price;
    private LocalDateTime from;
    private LocalDateTime to;
}
