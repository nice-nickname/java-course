package container;

import java.util.List;

import data.Flat;

public interface FlatsContainer {

    /**
     * Поиск по площади по заданным границам
     */
    List<Flat> findByArea(double lowerArea, double upperArea);

    /**
     * Добавление новой Flat
     * @param flat
     */
    void add(Flat flat);
}