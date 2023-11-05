package container;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import data.Flat;

public class MapFlatContainer implements FlatsContainer {

    private final TreeMap<Double, List<Flat>> flats;

    public MapFlatContainer(List<Flat> flats) {
        this.flats = new TreeMap<Double, List<Flat>>();

        for (Flat flat : flats) {
            add(flat);
        }
    }

    @Override
    public List<Flat> findByArea(double lowerArea, double upperArea) {
        var flatsByArea = this.flats.subMap(lowerArea, true, upperArea, true);

        return flatsByArea.entrySet().stream()
                .flatMap(s -> s.getValue().stream())
                .collect(Collectors.toList());
    }

    @Override
    public void add(Flat flat) {
        var area = flat.getArea();

        List<Flat> currentFlats;
        if (this.flats.containsKey(flat.getArea())) {
            currentFlats = flats.get(area);
        } else {
            currentFlats = new ArrayList<Flat>();
        }

        currentFlats.add(flat);

        this.flats.put(area, currentFlats);
    }

    @Override
    public String toString() {
        return this.flats.entrySet().stream()
                .flatMap(s -> s.getValue().stream())
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}