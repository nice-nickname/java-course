package container

import data.Flat

class ListFlatContainer(flats: List<Flat>) : FlatsContainer {

    private val flatsList: MutableList<Flat> = ArrayList(flats)

    override fun findByArea(lowerArea: Double, upperArea: Double): List<Flat> {
        return flatsList.filter { flat ->
            flat.area >= lowerArea && flat.area <= upperArea
        }
    }

    override fun add(flat: Flat) {
        flatsList.add(flat)
    }

    override fun toString(): String {
        return flatsList.joinToString("\n") { it.toString() }
    }
}
