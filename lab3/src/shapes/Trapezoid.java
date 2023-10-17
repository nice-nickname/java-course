package shapes;

import geometry.Line;
import geometry.Point;

public class Trapezoid extends Shape {

    protected Trapezoid(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        var edges = this.getEdgeLines();

        var a = edges[0].length();
        var b = edges[1].length();
        var c = edges[2].length();
        var d = edges[3].length();

        var T = a - c;
        var D = d * d - b * b;
        var R = (T * T - D) / (2 * T);
        var h = Math.sqrt(b * b - R * R);

        var area = h * (a + c) / 2;

        return area;
    }

    @Override
    public boolean isExists() {
        var edges = this.getEdgeLines();
        
        var bottom = edges[0];
        var top = edges[2];
        var left = edges[1];
        var right = edges[3];

        return Line.isParallel(bottom, top) && !Line.isParallel(left, right);
    }
}
