package shapes;

import geometry.GeometryMath;
import geometry.Line;
import geometry.Point;

public abstract class Shape {
    
    protected final Point[] points;

    protected Shape(Point[] points) {
        this.points = points;
    }

    public Point getCenter() {
        double x = 0;
        double y = 0;

        for (var i = 0; i < this.points.length; i++) {
            x += this.points[i].getX();
            y += this.points[i].getY();
        }

        return new Point(x, y);
    }

    public Point[] getPoints() {
        return this.points;
    }

    public Line[] getEdges() {
        var lines = new Line[this.points.length];
        var linesCount = this.points.length;

        for (var i = 0; i < linesCount - 1; i++) {
            lines[i] = new Line(this.points[i], this.points[i + 1]);
        }
        lines[linesCount - 1] = new Line(this.points[linesCount - 1], this.points[0]);

        return lines;
    }

    public void rotate(int degrees) {
        double radians = GeometryMath.degreesToRadian(degrees);
        
        for (Point point : points) {
            point.setX(point.getX() * Math.cos(radians) - point.getY() * Math.sin(radians));
            point.setX(point.getX() * Math.sin(radians) + point.getY() * Math.cos(radians));
        }
    }

    public void move(double offsetX, double offsetY) {
        for (Point point : points) {
            point.move(offsetX, offsetY);
        }
    }

    public abstract double getArea();
    public abstract boolean IsExists();
}
