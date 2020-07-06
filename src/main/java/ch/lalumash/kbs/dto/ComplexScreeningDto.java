package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ComplexScreeningDto {
    private UUID uuid;
    private MovieDto movie;
    private HallDto hall;
    private LocalDateTime time;

    public static ComplexScreeningDto fromScreening(Screening screening) {
        return new ComplexScreeningDto(
                screening.getUuid(),
                MovieDto.fromMovie(screening.getMovie()),
                HallDto.fromHall(screening.getHall(), screening),
                screening.getTime()
        );
    }
}
