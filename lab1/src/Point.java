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

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f]", this.x, this.y);
    }


    public static double magniture(Point from, Point to) {
        var subX = to.x - from.x;
        var subY = to.y - from.y;

        return Math.sqrt(subX * subX + subY * subY);
    }
}
