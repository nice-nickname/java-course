package geometry;

public class Point {
    
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double value) {
        this.x = value;
    }

    public void setY(double value) {
        this.y = value;
    }

    public void move(double offsetX, double offsetY) {
        this.x += offsetX;
        this.y += offsetY;
    }

    public double magnitude() {
        return Math.sqrt(
            x * x + y * y
        );
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f]", this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            var point = (Point)obj;
            return this.x == point.x && this.y == point.y;
        }
        
        return false;
    }

    public static double dot(Point v1, Point v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static Point copy(Point other) {
        return new Point(other.x, other.y);
    }
}
