package geometry

import kotlin.math.abs
import kotlin.math.acos

class Line(private val start: Point, private val end: Point) {

    fun getStart(): Point {
        return this.start
    }

    fun getEnd(): Point {
        return this.end
    }

    fun length(): Double {
        return asVector().magnitude()
    }

    fun asVector(): Point {
        return Point(end.getX() - start.getX(), end.getY() - start.getY())
    }

    fun isIntersecting(rhs: Line): Boolean {
        val p1 = this.start
        val p2 = this.end
        val p3 = rhs.start
        val p4 = rhs.end

        if (p1 == p3 || p2 == p4) {
            return true
        }

        val v1 = (p4.getX() - p3.getX()) * (p1.getY() - p3.getY()) - (p4.getY() - p3.getY()) * (p1.getX() - p3.getX())
        val v2 = (p4.getY() - p3.getY()) * (p2.getX() - p1.getX()) - (p4.getX() - p3.getX()) * (p2.getY() - p1.getY())
        val v3 = (p2.getX() - p1.getX()) * (p1.getY() - p3.getY()) - (p2.getY() - p1.getY()) * (p1.getX() - p3.getX())
        val v4 = (p4.getY() - p3.getY()) * (p2.getX() - p1.getX()) - (p4.getX() - p3.getX()) * (p2.getY() - p1.getY())

        val u1 = v1 / v2
        val u2 = v3 / v4

        return u1 >= 0 && u1 <= 1 &&
                u2 >= 0 && u2 <= 1
    }

    companion object {
        fun angle(lhs: Line, rhs: Line): Double {
            val v1 = Point(lhs.getEnd().getX() - lhs.getStart().getX(), lhs.getEnd().getY() - lhs.getStart().getY())
            val v2 = Point(rhs.getEnd().getX() - rhs.getStart().getX(), rhs.getEnd().getY() - rhs.getStart().getY())

            val scalar = Point.dot(v1, v2)

            val m1 = lhs.length()
            val m2 = rhs.length()

            return acos(scalar / (m1 * m2))
        }

        fun isParallel(lhs: Line, rhs: Line): Boolean {
            val magnitude = lhs.length() * rhs.length()
            val scalar = Point.dot(lhs.asVector(), rhs.asVector())

            return magnitude == abs(scalar)
        }

        fun inverse(l: Line): Line {
            return Line(
                Point.copy(l.getEnd()),
                Point.copy(l.getStart())
            )
        }
    }
}
