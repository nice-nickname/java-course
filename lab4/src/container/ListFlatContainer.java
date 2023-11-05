package container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import data.Flat;

public class ListFlatContainer implements FlatsContainer {

    private final List<Flat> flats;

    public ListFlatContainer(List<Flat> flats) {
        this.flats = new ArrayList<>(flats);
    }

    @Override
    public List<Flat> findByArea(double lowerArea, double upperArea) {
        return this.flats.stream()
                .filter(s -> lowerArea >= s.getArea() && upperArea <= s.getArea())
                .collect(Collectors.toList());
    }

    @Override
    public void add(Flat flat) {
        this.flats.add(flat);
    }

    @Override
    public String toString() {
        return this.flats.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
