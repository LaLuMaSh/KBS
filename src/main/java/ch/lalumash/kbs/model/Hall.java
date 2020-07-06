package ch.lalumash.kbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Hall {
    private String id;
    private List<Row> rows;
}
