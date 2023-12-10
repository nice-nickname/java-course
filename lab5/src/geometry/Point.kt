package geometry

import kotlin.math.sqrt

class Point(private var x: Double, private var y: Double) {

    fun getX(): Double {
        return this.x
    }

    fun getY(): Double {
        return this.y
    }

    fun setX(value: Double) {
        this.x = value
    }

    fun setY(value: Double) {
        this.y = value
    }

    fun move(offsetX: Double, offsetY: Double) {
        this.x += offsetX
        this.y += offsetY
    }

    fun magnitude(): Double {
        return sqrt(
            x * x + y * y
        )
    }

    override fun toString(): String {
        return String.format("[%.2f, %.2f]", this.x, this.y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Point) return false

        return this.x == other.x &&
                this.y == other.y
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    companion object {
        fun dot(v1: Point, v2: Point): Double {
            return v1.x * v2.x + v1.y * v2.y
        }

        fun copy(other: Point): Point {
            return Point(other.x, other.y)
        }
    }
}
