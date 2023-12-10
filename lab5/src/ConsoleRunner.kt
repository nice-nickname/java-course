import geometry.GeometryMath
import geometry.Point
import shapes.Shape
import java.security.InvalidParameterException
import java.util.*
import kotlin.system.exitProcess

class ConsoleRunner {
    private val sc: Scanner = Scanner(System.`in`)
    private lateinit var first: Shape
    private lateinit var second: Shape

    fun run() {
        try {
            first = readShape()
            second = readShape()
        } catch (e: Exception) {
            println(e.message)
            exitProcess(-1)
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

    private fun printMenu() {
        println("0 - exit; 1 - print menu;")
        println("2 - print area; 3 - compare by area; 4 - move figure;")
        println("5 - rotate figure; 6 - check intersection; 7 - check inclusion;")
        println("8 - print figure")
    }

    private fun loop() {
        print(">>> ")
        val operation = sc.nextInt()

        when (operation) {
            0 -> exitProcess(0)
            1 -> printMenu()
            2 -> handlePrintArea()
            3 -> handleCompareByArea()
            4 -> handleMove()
            5 -> handleRotate()
            6 -> handleCheckIntersection()
            7 -> handleCheckInclusion()
            8 -> handlePrint()
            else -> {
            }
        }
    }

    private fun handlePrintArea() {
        val shape = chooseShape()
        println("Area = ${shape?.getArea()}")
    }

    private fun handleCompareByArea() {
        val cmpResult = GeometryMath.compareByArea(first, second)

        when {
            cmpResult > 0 -> println("first is greater")
            cmpResult == 0 -> println("Figures are equal")
            else -> println("Second is greater")
        }
    }

    private fun handleMove() {
        val shape = chooseShape()

        print("enter offsetX and offsetY: ")
        val x = sc.nextDouble()
        val y = sc.nextDouble()
        shape?.move(x, y)
    }

    private fun handleRotate() {
        print("Enter angle in degrees: ")
        val degrees = sc.nextInt()

        val shape = chooseShape()
        shape?.rotate(degrees)
    }

    private fun handleCheckIntersection() {
        val isIntersecting = GeometryMath.isIntersect(first, second)

        if (isIntersecting) {
            println("yes")
        } else {
            println("no")
        }
    }

    private fun handleCheckInclusion() {
        val isIncluding = GeometryMath.isIncludes(first, second)

        if (isIncluding) {
            println("first is includes second")
        } else {
            println("no")
        }
    }

    private fun handlePrint() {
        val shape = chooseShape()
        println(shape)
    }

    private fun chooseShape(): Shape {
        print("Choose which shape to use (1 / 2): ")
        val s = sc.nextInt()

        return if (s == 1) {
            first
        } else {
            second
        }
    }

    private fun readShape(): Shape {
        val points = arrayOfNulls<Point>(4)

        println("Enter 4 points for shape:")

        for (i in points.indices) {
            val x = sc.nextDouble()
            val y = sc.nextDouble()
            points[i] = Point(x, y)
        }

        print("Enter figure type [R]ectangle / [T]rapezoid: ")
        val type = sc.next()[0]

        val shape = Shape.createShape(type, points.requireNoNulls())

        if (shape == null) {
            throw InvalidParameterException("Unknown figure type '$type'")
        }

        if (!shape.isExists()) {
            throw InvalidParameterException("Invalid points for shape")
        }

        return shape
    }
}

fun main() {
    ConsoleRunner().run()
}
