package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ScreeningDto {
    private UUID uuid;
    private String hall;
    private String movieName;
    private LocalDateTime time;

    public static ScreeningDto fromScreening(Screening screening) {
        return new ScreeningDto(screening.getUuid(), screening.getHall().getId(), screening.getMovie().getTitle(), screening.getTime());
    }
}
