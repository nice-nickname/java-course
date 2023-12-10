package shapes

import geometry.Line
import geometry.Point
import kotlin.math.sqrt

class Trapezoid(points: Array<Point>) : Shape(points) {

    override fun getArea(): Double {
        val edges = this.getEdgeLines()

        val a = edges[0].length()
        val b = edges[1].length()
        val c = edges[2].length()
        val d = edges[3].length()

        val T = a - c
        val D = d * d - b * b
        val R = (T * T - D) / (2 * T)
        val h = sqrt(b * b - R * R)

        return h * (a + c) / 2
    }

    override fun isExists(): Boolean {
        val edges = this.getEdgeLines()

        val bottom = edges[0]
        val top = edges[2]
        val left = edges[1]
        val right = edges[3]

        return Line.isParallel(bottom, top) && !Line.isParallel(left, right)
    }
}
