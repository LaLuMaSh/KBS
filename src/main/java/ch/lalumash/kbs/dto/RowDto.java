package ch.lalumash.kbs.dto;

import ch.lalumash.kbs.model.Row;
import ch.lalumash.kbs.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class RowDto {
    private int id;
    private List<PlaceDto> places;

    public static RowDto fromRow(Row row, Screening screening) {
        return
                new RowDto(
                        row.getId(),
                        row.getPlaces()
                                .stream()
                                .map(place -> PlaceDto.fromPlace(place, screening))
                                .collect(Collectors.toList())
                );
    }
}
