package geometry

import shapes.Shape

object GeometryMath {

    const val PI = Math.PI

    /**
     * Перевод величины угла
     * @param degrees - угол в градусах
     * @return угол в радианах
     */
    fun degreesToRadian(degrees: Int): Double {
        return (degrees % 360) * PI / 180
    }

    /**
     * Сравнение фигур по площади
     */
    fun compareByArea(lhs: Shape, rhs: Shape): Int {
        return lhs.getArea().compareTo(rhs.getArea())
    }

    /**
     * Определение пересечения фигур
     */
    fun isIntersect(lhs: Shape, rhs: Shape): Boolean {
        val lhsEdges = lhs.getEdgeLines()
        val rhsEdges = rhs.getEdgeLines()

        for (l1 in lhsEdges) {
            for (l2 in rhsEdges) {
                if (l1.isIntersecting(l2)) {
                    return true
                }
            }
        }

        return false
    }

    /**
     * Определение включения точки в фигуру
     * Алгоритм строит линии с началом в точке P, и концами на точках (вершинах) Shape
     * Если угол между всеми этими линиями равен 360 -> точка включается в фигуру
     */
    fun isIncludes(p: Point, shape: Shape): Boolean {
        val points = shape.getPoints()

        for (point in points) {
            if (p == point) {
                return true
            }
        }

        val checkLinesCount = points.size + 1
        val checkLines = arrayOfNulls<Line>(checkLinesCount)

        for (i in 0..< checkLinesCount - 1) {
            checkLines[i] = Line(p, points[i])
        }
        checkLines[checkLinesCount - 1] = checkLines[0]

        var angle = 0.0
        for (i in 0..< checkLinesCount - 1) {
            angle += Line.angle(checkLines[i]!!, checkLines[i + 1]!!)
        }

        return angle == 2 * PI
    }

    /**
     * Определение включения фигуры в другую
     */
    fun isIncludes(lhs: Shape, rhs: Shape): Boolean {
        val points = rhs.getPoints()

        for (point in points) {
            if (!isIncludes(point, lhs)) {
                return false
            }
        }

        return true
    }
}
