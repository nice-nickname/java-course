package geometry;

public class Line {
    
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return this.end;
    }

    public Point getEnd() {
        return this.start;
    }

    public double magintude() {
        return Point.magniture(this.end, this.start);
    }

    public boolean isIntersecting(Line rhs) {
        Point p1 = this.start;
        Point p2 = this.end;
        Point p3 = rhs.start;
        Point p4 = rhs.end;

        if (p1.equals(p3) || p2.equals(p4)) {
            return true;
        }

        double v1 = (p4.getX() - p3.getX()) * (p1.getY() - p3.getY()) - (p4.getY() - p3.getY()) * (p1.getX() - p3.getX());
        double v2 = (p4.getY() - p3.getY()) * (p2.getX() - p1.getX()) - (p4.getX() - p3.getX()) * (p2.getY() - p1.getY());
        double v3 = (p2.getX() - p1.getX()) * (p1.getY() - p3.getY()) - (p2.getY() - p1.getY()) * (p1.getX() - p3.getX());
        double v4 = (p4.getY() - p3.getY()) * (p2.getX() - p1.getX()) - (p4.getX() - p3.getX()) * (p2.getY() - p1.getY());

        double u1 = v1 / v2, u2 = v3 / v4;

        return u1 >= 0 && u1 <= 1 && u2 >= 0 && u2 <= 1;
    }

    public static double angle(Line lhs, Line rhs) {
        var v1 = new Point(lhs.getEnd().getX() - lhs.getStart().getX(), lhs.getEnd().getY() - lhs.getStart().getY());
        var v2 = new Point(rhs.getEnd().getX() - rhs.getStart().getX(), rhs.getEnd().getY() - rhs.getStart().getY());

        double scalar = v1.getX() * v2.getX() + v1.getY() * v2.getY();

        double m1 = lhs.magintude();
        double m2 = rhs.magintude();

        return Math.acos(scalar / (m1 * m2));
    }
}
