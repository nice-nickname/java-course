package data

import java.io.File
import java.util.Scanner

object FileReader {

    fun readFlats(fileName: String): List<Flat> {
        val flats = mutableListOf<Flat>()

        try {
            val file = File(fileName)
            file.forEachLine { line: String ->
                val scanner = Scanner(line)
                val roomsCount = scanner.nextInt()
                val floor = scanner.nextInt()
                val area = scanner.nextDouble()
                val district = scanner.next()

                val flat = Flat(district, roomsCount, floor, area)
                flats.add(flat)
            }
        } catch (e: Exception) {
            System.err.println(e)
        }

        return flats
    }
}
