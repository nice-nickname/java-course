package shapes

import geometry.GeometryMath
import geometry.Line
import geometry.Point
import kotlin.math.cos
import kotlin.math.sin

abstract class Shape protected constructor(private val points: Array<Point>) {

    open fun getCenter(): Point {
        var x = 0.0
        var y = 0.0

        for (point in this.points) {
            x += point.getX()
            y += point.getY()
        }

        return Point(x / 3, y / 3)
    }

    fun getPoints(): Array<Point> {
        return this.points
    }

    /**
     * Метод получения сторон фигуры
     * @return массив линий - сторон
     */
    fun getEdgeLines(): Array<Line> {
        val lines = arrayOfNulls<Line>(this.points.size)
        val linesCount = this.points.size

        for (i in 0..< linesCount - 1) {
            lines[i] = Line(this.points[i], this.points[i + 1])
        }
        lines[linesCount - 1] = Line(this.points[linesCount - 1], this.points[0])

        @Suppress("UNCHECKED_CAST")
        return lines as Array<Line>
    }

    /**
     * Поворот
     * @param degrees - угол в градусах
     */
    open fun rotate(degrees: Int) {
        val radians = GeometryMath.degreesToRadian(degrees)

        for (point in points) {
            val x = point.getX()
            val y = point.getY()

            point.setX(x * cos(radians) - y * sin(radians))
            point.setY(x * sin(radians) + y * cos(radians))
        }
    }

    fun move(offsetX: Double, offsetY: Double) {
        for (point in points) {
            point.move(offsetX, offsetY)
        }
    }

    abstract fun getArea(): Double
    abstract fun isExists(): Boolean

    override fun toString(): String {
        return points.joinToString("\n") { it.toString() }
    }

    companion object {
        fun createShape(code: Char, points: Array<Point>): Shape? {
            return when (code) {
                'R' -> Rectangle(points)
                'T' -> Trapezoid(points)
                else -> null
            }
        }
    }
}
