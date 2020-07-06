package ch.lalumash.kbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ReservationDto {
    public LocationDto[] places;
    public UUID customerUuid;
    public UUID screeningUuid;
}
