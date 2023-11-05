package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<Flat> readFlats(String fileName) {
        List<Flat> flats = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                int roomsCount = scanner.nextInt();
                int floor = scanner.nextInt();
                double area = scanner.nextDouble();
                String district = scanner.next();

                Flat flat = new Flat(district, roomsCount, floor, area);
                flats.add(flat);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return flats;
    }
}
