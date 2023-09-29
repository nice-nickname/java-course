import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleRunner {

    private final Scanner sc;

    private Triangle triangle = null;

    public ConsoleRunner() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        try {
            this.triangle = readTriangle();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        printMenu();
        
        while (true) {
            try {
                loop();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void loop() {
        System.out.print(">>> ");

        int operation = sc.nextInt();

        switch (operation) {
            case 0:
                System.exit(0);
                return;

            case 1:
                printMenu();
                break;

            case 2:
                handlePrintTriangle();
                break;

            case 3:
                handlePrintCenter();
                break;

            case 4:
                handlePrintArea();
                break;

            case 5:
                handlePrintPerimeter();
                break;

            case 6:
                handleMove();
                break;

            case 7:
                handleScale();
                break;

            case 8:
                handleCompare();
                break;

            default:
                break;
        }
    }

    private void printMenu() {
        System.out.println("0 - exit; 1 - print menu;\n" +
                           "2 - print triangle; 3 - print center; 4 - print area; 5 - print perimeter;\n" +
                           "6 - move triangle; 7 - scale triangle; 8 - compare by area;\n");
    }

    private void handlePrintTriangle() {
        System.out.println(this.triangle);
    }

    private void handlePrintArea() {
        System.out.println(this.triangle.findArea());
    }

    private void handlePrintPerimeter() {
        System.out.println(this.triangle.findPerimeter());
    }

    private void handlePrintCenter() {
        System.out.println(this.triangle.findCenter());
    }

    private void handleMove() {
        System.out.println("Enter offset (x, y)");
        var x = sc.nextDouble();
        var y = sc.nextDouble();

        this.triangle.move(new Point(x, y));
    }

    private void handleScale() {
        System.out.println("Enter scale factor");
        var scale = sc.nextDouble();

        this.triangle.scale(scale);
    }

    private void handleCompare() {
        Triangle other = readTriangle();
        var compare = this.triangle.compareTo(other);

        if (compare > 0) {
            System.out.println("greater");
        }
        else if (compare == 0) {
            System.out.println("equal");
        }
        else {
            System.out.println("less");
        }
    }

    private Triangle readTriangle() {
        System.out.println("Введите координаты вершин треугольника:");

        ArrayList<Point> points = new ArrayList<Point>();

        for (int i = 0; i < 3; i++) {
            var x = sc.nextDouble();
            var y = sc.nextDouble();

            points.add(new Point(x, y));
        }

        return new Triangle(points.get(0), points.get(1), points.get(2));
    }
}
