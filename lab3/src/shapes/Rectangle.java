package shapes;

import geometry.GeometryMath;
import geometry.Line;
import geometry.Point;

public class Rectangle extends Shape {

    protected Rectangle(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        var edges = this.getEdgeLines();

        return edges[0].length() * edges[1].length();
    }

    @Override
    public boolean isExists() {
        var edges = this.getEdgeLines();

        var a = Line.angle(edges[0], edges[1]);
        var b = Line.angle(edges[1], edges[2]);
        var c = Line.angle(edges[2], edges[3]);
        var d = Line.angle(edges[3], edges[0]);
        
        return a + b + c + d == GeometryMath.PI * 2;
    }
}
