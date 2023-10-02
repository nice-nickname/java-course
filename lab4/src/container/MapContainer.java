package container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import data.Flat;

public class MapContainer implements FlatsContainer {

    private final TreeMap<Double, ArrayList<Flat>> flats;

    public MapContainer(List<Flat> flats) {
        this.flats = new TreeMap<Double, ArrayList<Flat>>();

        for (Flat flat : flats) {
            Add(flat);
        }
    }

    @Override
    public List<Flat> findByArea(double area) {
        var lowerArea = area * 0.9;
        var upperArea = area * 1.1;

        var flatsStream = this.flats.entrySet().stream();

        return flatsStream
                .filter(s -> lowerArea >= s.getKey() && upperArea <= s.getKey())
                .flatMap(s -> s.getValue().stream())
                .collect(Collectors.toList());
    }

    private void Add(Flat flat) {
        var area = flat.getArea();

        ArrayList<Flat> currentFlats;
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