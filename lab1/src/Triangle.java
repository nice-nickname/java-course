import java.security.InvalidParameterException;

public class Triangle implements Comparable<Triangle> {

    private final Point[] points;

    public Triangle(Point a, Point b, Point c) {
        points = new Point[] { a, b, c };
        checkTriangleExisting(points);
    }

    public double findPerimeter() {
        var m = findMagnitudes(this.points);
        double a = m[0], b = m[1], c = m[2];

        return a + b + c;
    }

    public double findArea() {
        var m = findMagnitudes(this.points);
        double a = m[0], b = m[1], c = m[2];

        var p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) + (p - c));
    }

    public Point findCenter() {
        double x = 0, y = 0;

        for (Point point : points) {
            x += point.getX();
            y += point.getY();
        }

        return new Point(x / 3, y / 3);
    }

    public void move(Point offset) {
        for (Point point : points) {
            point.move(offset.getX(), offset.getY());
        }
    }

    public void scale(double factor) throws InvalidParameterException {
        if (factor <= 0) {
            throw new InvalidParameterException("Scale factor cannot be less than null");
        }

        for (Point point : points) {
            double x = point.getX(), y = point.getY();

            point.setX(x * factor);
            point.setY(y * factor);
        }
    }

    @Override
    public String toString() {
        return String.format("{\n  %s\n  %s\n  %s\n}\n", points[0], points[1], points[2]);
    }

    @Override
    public int compareTo(Triangle other) {
        var areaDiff = this.findArea() - other.findArea();

        return Double.compare(areaDiff, 0);
    }

    private static double[] findMagnitudes(Point[] points) {
        var a = Point.magniture(points[0], points[1]);
        var b = Point.magniture(points[1], points[2]);
        var c = Point.magniture(points[2], points[0]);

        return new double[] { a, b, c };
    }

    private static void checkTriangleExisting(Point[] points) throws InvalidParameterException {
        var m = findMagnitudes(points);
        double a = m[0], b = m[1], c = m[2];

        if ((a + b <= c) || (b + c <= a) || (c + a <= b)) {
            throw new InvalidParameterException("Triangle with this poinst doesn't exist");
        }
    }
}
