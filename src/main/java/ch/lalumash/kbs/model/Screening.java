package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Screening {
    private UUID uuid;
    private Movie movie;
    private Hall hall;
    private LocalDateTime time;
}
