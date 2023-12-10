import container.FlatsContainer
import container.ListFlatContainer
import container.MapFlatContainer
import data.FileReader
import data.Flat
import java.util.*
import kotlin.system.exitProcess

class ConsoleRunner {
    private val sc: Scanner = Scanner(System.`in`)
    private lateinit var container: FlatsContainer

    fun run() {
        val flats = FileReader.readFlats("C:\\Users\\ahaha\\repos\\java-course\\lab6\\dataset.txt")

        println("Choose container [M]ap / [L]ist")
        val c = sc.nextLine().uppercase()[0]

        container = if (c == 'M') {
            MapFlatContainer(flats)
        } else {
            ListFlatContainer(flats)
        }

        printMenu()

        while (true) {
            try {
                loop()
            } catch (e: Exception) {
                System.err.println(e.message)
            }
        }
    }

    private fun loop() {
        print(">>> ")
        val action = sc.nextInt()

        when (action) {
            0 -> exitProcess(0)
            1 -> handleAddFlat()
            2 -> handleFindByArea()
            3 -> handlePrintAll()
            else -> {
            }
        }
    }

    /**
     * Вывод меню
     */
    private fun printMenu() {
        println("0 - exit; 1 - add flat; 2 - find by area; 3 - print all;")
    }

    /**
     * Поиск по площади
     */
    private fun handleFindByArea() {
        print("Enter area: ")
        val area = sc.nextDouble()
        val results = container.findByArea(area * 0.9, area * 1.1)
        printFlats(results)
    }

    /**
     * Добавление новой квартиры
     */
    private fun handleAddFlat() {
        print("Enter area: ")
        val area = sc.nextDouble()

        print("Enter floor: ")
        val floor = sc.nextInt()

        print("Enter count of rooms: ")
        val roomsCount = sc.nextInt()

        print("Enter district: ")
        val district = sc.next()

        container.add(Flat(district, roomsCount, floor, area))
    }

    /**
     * Вывод всех квартир
     */
    private fun handlePrintAll() {
        println(container)
    }

    private fun printFlats(flats: List<Flat>) {
        val flatsAsString = flats.joinToString("\n") { it.toString() }
        println(flatsAsString)
    }
}
