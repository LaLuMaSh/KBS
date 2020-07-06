package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Hall;
import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class HallDto {
    private String id;
    private List<RowDto> rows;

    public static HallDto fromHall(Hall hall, Screening screening) {
        return
                new HallDto(
                        hall.getId(),
                        hall.getRows()
                                .stream()
                                .map(row -> RowDto.fromRow(row, screening))
                                .collect(Collectors.toList())
                );
    }
}
