package ch.lalumash.kbs.datastorage;

import ch.lalumash.kbs.model.*;

import java.util.ArrayList;
import java.util.List;

public class MockDataHelpers {
    public static Hall createHall(String id, int rowCount, int placeCount) {
        List<Row> rows = new ArrayList<>();
        for (int i = 1; i <= rowCount; i++) {
            rows.add(createRow(i, placeCount));
        }
        return new Hall(id, rows);
    }
    public static Row createRow(int id, int placeCount) {
        List<Place> places = new ArrayList<>();
        for (int i = 1; i <= placeCount; i++) {
            places.add(new Place(i, new ArrayList<>()));
        }
        return new Row(id ,places);
    }
}
