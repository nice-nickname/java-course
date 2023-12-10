package container

import data.Flat
import java.util.*

class MapFlatContainer(flats: List<Flat>) : FlatsContainer {

    private val flatsMap: TreeMap<Double, MutableList<Flat>> = TreeMap()

    init {
        flats.forEach { add(it) }
    }

    override fun findByArea(lowerArea: Double, upperArea: Double): List<Flat> {
        val flatsByArea = flatsMap.subMap(lowerArea, true, upperArea, true)

        return flatsByArea.values.flatten()
    }

    override fun add(flat: Flat) {
        val area = flat.area

        val currentFlats = flatsMap.getOrPut(area) { mutableListOf() }
        currentFlats.add(flat)
    }

    override fun toString(): String {
        return flatsMap.values.flatten().joinToString("\n") { it.toString() }
    }
}
