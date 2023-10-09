package shapes;

import geometry.Point;

public class Trapezoid extends Shape {

    protected Trapezoid(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        var edges = this.getEdges();

        var a = edges[1].magintude();
        var b = edges[3].magintude();
        var c = edges[0].magintude();
        var d = edges[2].magintude();

        var asideRoot = (a + b) / 2;
        var secondArg = (((b - a) * (b - a) + c * c - d * d ) 
                            /
                         (2 * (b - a)));

        var innerRoot = c * c - secondArg * secondArg;

        return asideRoot * Math.sqrt(innerRoot);
    }

    @Override
    public boolean IsExists() {
        return true;
    }
}
