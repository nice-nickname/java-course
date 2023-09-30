import java.security.InvalidParameterException;
import java.util.Scanner;

public class ConsoleRunner {

    private Scanner sc = null;
    private char type;

    public ConsoleRunner() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter type of pair (F/C)");
        this.type = sc.next().charAt(0);

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
                break;

            case 1:
                printMenu();
                break;

            case 2:
                handleAdd();
                break;

            case 3:
                handeSubtract();
                break;

            case 4:
                handleMultiply();
                break;

            case 5:
                handleDivide();
                break;

            default:
                break;
        }
    }

    private void printMenu() {
        System.out.println("0 - exit; 1 - print menu;\n" +
                           "2 - add; 3 - subtract; 4 - multiply; 5 - divide;");  
    }

    private void handleAdd() {
        var a = createPair();
        var b = createPair();

        System.out.print(a + "  +  " + b + " = ");
        a.add(b);
        System.out.println(a);
    }

    private void handeSubtract() {
        var a = createPair();
        var b = createPair();

        System.out.print(a + "  -  " + b + " = ");
        a.subtract(b);
        System.out.println(a);
    }

    private void handleMultiply() {
        var a = createPair();
        var b = createPair();

        System.out.print(a + "  *  " + b + " = ");
        a.multiply(b);
        System.out.println(a);
    }

    private void handleDivide() {
        var a = createPair();
        var b = createPair();

        System.out.print(a + "  /  " + b + " = ");
        a.divide(b);
        System.out.println(a);
    }

    private Pair createPair() {
        System.out.print("Enter two numbers: ");

        if (this.type == 'C') {
            return new Complex(sc.nextInt(), sc.nextInt());
        } else if (type == 'F') {
            return new Fractional(sc.nextInt(), sc.nextInt());
        }

        throw new InvalidParameterException(type + " is not supported");
    }
}
