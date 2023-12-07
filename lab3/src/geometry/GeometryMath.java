package geometry;

import shapes.Shape;

public class GeometryMath {

    public static final double PI = Math.PI;
    
    /**
     * Перевод величины угла
     * @param degrees - угол в градусах
     * @return угол в радианах
     */
    public static double degreesToRadian(int degrees) {
        return (degrees % 360) * PI / 180;
    }

    /**
     * Сравнение фигур по площади
     */
    public static int compareByArea(Shape lhs, Shape rhs) {
        return Double.compare(lhs.getArea(), rhs.getArea());
    }


    /**
     * Определение пересечения фигур
     */
    public static boolean isIntersect(Shape lhs, Shape rhs) {
        var lhsEdges = lhs.getEdgeLines();
        var rhsEdges = rhs.getEdgeLines();

        for (var i = 0; i < lhsEdges.length; i++) {
            var l1 = lhsEdges[i];

            for (var j = 0; j < rhsEdges.length; j++) {
                var l2 = rhsEdges[j];

                if (l1.isIntersecting(l2)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    /**
     * Определение включения точки в фигуру
     * Алгоритм строит линии с началом в точке P, и концами на точках (вершинах) Shape
     * Если угол между всеми этими линиями равен 360 -> точка включается в фигуру
     */
    public static boolean isIncludes(Point p, Shape shape) {
        var points = shape.getPoints();

        for (var i = 0; i < points.length; i++) {
            if (p.equals(points[i])) {
                return true;
            }
        }

        var checkLinesCount = points.length + 1;
        var checkLines = new Line[checkLinesCount];

        for (var i = 0; i < checkLinesCount - 1; i++) {
            checkLines[i] = new Line(p, points[i]);
        }
        checkLines[checkLinesCount - 1] = checkLines[0];

        double angle = 0;
        for (var i = 0; i < checkLinesCount - 1; i++) {
            angle += Line.angle(checkLines[i], checkLines[i + 1]);
        }

        return angle == 2 * PI;
    }

    /**
     * Определение включения фигуры в другой
     */
    public static boolean isIncludes(Shape lhs, Shape rhs) {
        var points = rhs.getPoints();

        for (var i = 0; i < points.length; i++) {
            if (isIncludes(points[i], lhs) == false) {
                return false;
            }
        }

        return true;
    }
}
