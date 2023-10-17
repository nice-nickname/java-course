import java.security.InvalidParameterException;
import java.util.Scanner;

import geometry.GeometryMath;
import geometry.Point;
import shapes.Shape;

public class ConsoleRunner {
    
    private Scanner sc;
    private Shape first;
    private Shape second;

    public ConsoleRunner() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        try {
            this.first = readShape();
            this.second = readShape();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        printMenu();

        while (true) {
            try {
                loop();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("0 - exit; 1 - print menu;");
        System.out.println("2 - print area; 3 - compare by area; 4 - move figure;");
        System.out.println("5 - rotate figure; 6 - check intersection; 7 - check inclusion;");
        System.out.println("8 - print figure");
    }

    private void loop() {
        System.out.print(">>> ");

        var operation = sc.nextInt();

        switch (operation) {
            case 0:
                System.exit(0);
            case 1:
                printMenu();
                break;
            case 2:
                handlePrintArea();
                break;
            case 3:
                handleCompareByArea();
                break;
            case 4:
                handleMove();
                break;
            case 5:
                handleRotate();
                break;
            case 6:
                handleCheckIntersection();
                break;
            case 7:
                handleCheckInclusion();
                break;
            case 8:
                handlePrint();
                break;
        
            default:
                break;
        }
    }

    private void handlePrintArea() {
        var shape = chooseShape();
        System.out.println("Area = " + shape.getArea());
    }

    private void handleCompareByArea() {
        var cmpResult = GeometryMath.compareByArea(first, second);

        if (cmpResult > 0) {
            System.out.println("first is greater");
        }
        else if (cmpResult == 0) {
            System.out.println("Figures are equal");
        }
        else {
            System.out.println("Second is greater");
        }
    }

    private void handleMove() {
        var shape = chooseShape();

        System.out.print("enter offsetX and offsetY: ");
        var x = sc.nextDouble(); 
        var y = sc.nextDouble();
        shape.move(x, y);
    }

    private void handleRotate() {
        System.out.print("Enter angle in degrees: ");
        var degrees = sc.nextInt();

        var shape = chooseShape();
        shape.rotate(degrees);
    }

    private void handleCheckIntersection() {
        var isIntersecting = GeometryMath.isIntersect(first, second);

        if (isIntersecting) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    private void handleCheckInclusion() {
        var isIncluding = GeometryMath.isIncludes(first, second);

        if (isIncluding) {
            System.out.println("first is includes second");
        }
        else {
            System.out.println("no");
        }
    }

    private void handlePrint() {
        var shape = chooseShape();

        System.out.println(shape);
    }

    private Shape chooseShape() {
        System.out.print("Choose shich shape to use (1 / 2): ");
        var s = sc.nextInt();

        if (s == 1) {
            return first;
        }

        return second;
    }

    private Shape readShape() throws InvalidParameterException {
        var points = new Point[4];
        
        System.out.println("Enter 4 points for shape:");

        for (var i = 0; i < points.length; i++) {
            double x = sc.nextDouble(), y = sc.nextDouble();
            points[i] = new Point(x, y);
        }

        System.out.print("Enter figure type [R]ectangle / [T]rapezoid: ");
        char type = sc.next().charAt(0);
        
        var shape = Shape.createShape(type, points);

        if (shape == null) {
            throw new InvalidParameterException("Unknow figure type '" + type + "'");
        }

        if (!shape.isExists()) {
           throw new InvalidParameterException("Invalid points for shape");
        }

        return shape;
    }
}
