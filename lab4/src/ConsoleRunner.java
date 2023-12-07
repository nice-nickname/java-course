import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import container.FlatsContainer;
import container.ListFlatContainer;
import container.MapFlatContainer;
import data.FileReader;
import data.Flat;

public class ConsoleRunner {

    private final Scanner sc;
    private FlatsContainer container;

    public ConsoleRunner() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        var flats = FileReader.readFlats("/home/ahaha/java-course/lab4/dataset.txt");

        System.out.println("Choose container [M]ap / [L]ist");
        char c = sc.nextLine().charAt(0);

        if (c == 'M') {
            this.container = new MapFlatContainer(flats);
        }
        else {
            this.container = new ListFlatContainer(flats);
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
        var action = sc.nextInt();

        switch (action) {
            case 0:
                System.exit(0);
        
            case 1:
                handleAddFlat();
                break;

            case 2:
                handleFindByArea();
                break;

            case 3:
                handlePrintAll();
                break;
            
            default:
                break;
        }
    }

    /**
     * Вывод меню
     */
    private void printMenu() {
        System.out.println("0 - exit; 1 - add flat; 2 - find by area; 3 - print all;");
    }

    /**
     * Поиск по площади
     */
    private void handleFindByArea() {
        System.out.print("Enter area: ");

        var area = sc.nextDouble();
        var results = this.container.findByArea(area * 0.9, area * 1.1);

        printFlats(results);
    }

    /**
     * Добавление новой квартиры
     */
    private void handleAddFlat() {
        System.out.print("Enter area: ");

        var area = sc.nextDouble();

        System.out.print("Enter floor: ");

        var floor = sc.nextInt();

        System.out.print("Enter count of rooms: ");

        var roomsCount = sc.nextInt();

        System.out.print("Enter district: ");

        var district = sc.next();

        this.container.add(new Flat(district, roomsCount, floor, area));
    }

    /**
     * Вывод всех квартир
     */
    private void handlePrintAll() {
        System.out.println(this.container);
    }

    private void printFlats(List<Flat> flats) {
        var flatsAsString = flats.stream().map(Object::toString).collect(Collectors.joining("\n"));

        System.out.println(flatsAsString);
    }
}
