package shapes

import geometry.Line
import geometry.Point

class Rectangle(points: Array<Point>) : Shape(points) {

    override fun getArea(): Double {
        val edges = this.getEdgeLines()

        return edges[0].length() * edges[1].length()
    }

    override fun isExists(): Boolean {
        val edges = this.getEdgeLines()

        val bottom = edges[0]
        val right = edges[1]
        val top = edges[2]
        val left = edges[3]

        return Line.isParallel(top, bottom) && Line.isParallel(left, right)
    }
}
