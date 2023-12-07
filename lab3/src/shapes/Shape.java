package shapes;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import geometry.GeometryMath;
import geometry.Line;
import geometry.Point;

public abstract class Shape {
    
    protected final Point[] points;

    protected Shape(Point[] points) {
        this.points = points;
    }

<<<<<<< HEAD
    public Point getCenter() {
        double x = 0;
        double y = 0;

        for (var i = 0; i < this.points.length; i++) {
            x += this.points[i].getX();
            y += this.points[i].getY();
        }

        return new Point(x / 3, y / 3);
    }

=======
>>>>>>> b67dc2cd44ad23232b79af10259c81a92da0a34c
    public Point[] getPoints() {
        return this.points;
    }

    /**
     * Метод получения сторон фигуры
<<<<<<< HEAD
     * @return массив линий - сторон
=======
>>>>>>> b67dc2cd44ad23232b79af10259c81a92da0a34c
     */
    public Line[] getEdgeLines() {
        var lines = new Line[this.points.length];
        var linesCount = this.points.length;

        for (var i = 0; i < linesCount - 1; i++) {
            lines[i] = new Line(this.points[i], this.points[i + 1]);
        }
        lines[linesCount - 1] = new Line(this.points[linesCount - 1], this.points[0]);

        return lines;
    }

    /**
<<<<<<< HEAD
     * Поворот
     * @param degrees - угол в градусах
=======
     * Получение центра тяжести фигуры
     * @return центр тяжести
     */
    public Point getCenter() {
        double x = 0;
        double y = 0;

        for (var i = 0; i < this.points.length; i++) {
            x += this.points[i].getX();
            y += this.points[i].getY();
        }

        return new Point(x, y);
    }

    /**
     * Поворот фигуры вокруг с помощью матрицы поворота
     * @param degrees величина в градусах
>>>>>>> b67dc2cd44ad23232b79af10259c81a92da0a34c
     */
    public void rotate(int degrees) {
        double radians = GeometryMath.degreesToRadian(degrees);
        
        for (Point point : points) {
            var x = point.getX();
            var y = point.getY();

            point.setX(x * Math.cos(radians) - y * Math.sin(radians));
            point.setY(x * Math.sin(radians) + y * Math.cos(radians));
        }
    }

    /**
     * Перемещение фигуры
     * @param offsetX перемещение по X
     * @param offsetY перемещение по Y
     */
    public void move(double offsetX, double offsetY) {
        for (Point point : points) {
            point.move(offsetX, offsetY);
        }
    }

    /**
     * Расчет площади
     */
    public abstract double getArea();

    /**
     * Определения существования фигуры
     */
    public abstract boolean isExists();

    @Override
    public String toString() {
        return Stream.of(points)
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
    }


    public static Shape createShape(char code, Point[] points) {
        switch (code) {
            case 'R':
                return new Rectangle(points);
        
            case 'T':
                return new Trapezoid(points);

            default:
                return null;
        }
    }
}
