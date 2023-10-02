package container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import data.Flat;

public class ListContainer implements FlatsContainer {

    private final ArrayList<Flat> flats;

    public ListContainer(List<Flat> flats) {
        this.flats = new ArrayList<>(flats);
    }

    @Override
    public List<Flat> findByArea(double area) {
        var lowerArea = area * 0.9;
        var upperArea = area * 1.1;

        return this.flats.stream()
                .filter(s -> lowerArea >= s.getArea() && upperArea <= s.getArea())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.flats.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
