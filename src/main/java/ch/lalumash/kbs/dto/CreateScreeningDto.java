package ch.lalumash.kbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class CreateScreeningDto {
    private String title;
    private int amount;
    private LocalDateTime start;
    private String[] times;
}
