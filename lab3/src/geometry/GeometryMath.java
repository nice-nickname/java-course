package geometry;

import shapes.Shape;

public class GeometryMath {

    public static final double PI = Math.PI;
    
    public static double degreesToRadian(int degrees) {
        return (degrees % 360) * PI / 180;
    }

    public static int compareByArea(Shape lhs, Shape rhs) {
        return Double.compare(lhs.getArea(), rhs.getArea());
    }

    public static boolean isIntersect(Shape lhs, Shape rhs) {
        var lhsEdges = lhs.getEdges();
        var rhsEdges = rhs.getEdges();

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
    
    public static boolean isIncludes(Point p, Shape shape) {
        
    }

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
