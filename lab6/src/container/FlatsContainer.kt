package container

import data.Flat

interface FlatsContainer {
    /**
     * Поиск по площади по заданным границам
     */
    fun findByArea(lowerArea: Double, upperArea: Double): List<Flat>

    /**
     * Добавление новой Flat
     * @param flat
     */
    fun add(flat: Flat)
}
