package container;

import java.util.List;

import data.Flat;

public interface FlatsContainer {

    List<Flat> findByArea(double area);
}