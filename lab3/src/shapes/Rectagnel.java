package shapes;

import geometry.GeometryMath;
import geometry.Line;
import geometry.Point;

public class Rectagnel extends Shape {

    protected Rectagnel(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        var edges = this.getEdges();

        return edges[0].magintude() * edges[1].magintude();
    }

    @Override
    public boolean IsExists() {
        var edges = this.getEdges();

        var a = Line.angle(edges[0], edges[1]);
        var b = Line.angle(edges[1], edges[2]);
        var c = Line.angle(edges[2], edges[3]);
        var d = Line.angle(edges[3], edges[0]);

        
        return a + b + c + d == GeometryMath.PI * 2;
    }
}
