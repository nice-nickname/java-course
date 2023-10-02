package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<Flat> readFlats(String fileName) {
        List<Flat> flats = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                int roomsCount = scanner.nextInt();
                int floor = scanner.nextInt();
                double area = scanner.nextDouble();
                String district = scanner.nextLine();

                Flat flat = new Flat(district, roomsCount, floor, area);
                flats.add(flat);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return flats;
    }
}
