package shapes;

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

        var bottom = edges[0];
        var right = edges[1];
        var top = edges[2];
        var left = edges[3];
        
<<<<<<< HEAD
        return Line.isParallel(top, bottom) && Line.isParallel(left, right);
=======
        return Line.isParallel(top, bottom) && Line.isParallel(right, left);
>>>>>>> b67dc2cd44ad23232b79af10259c81a92da0a34c
    }
}
