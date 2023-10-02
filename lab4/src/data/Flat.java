package data;

public class Flat {

    private final String district;
    private final int roomsCount;
    private final int floor;
    private final double area;

    public Flat(String district, int rooms, int floor, double area) {
        this.district = district;
        this.roomsCount = rooms;
        this.floor = floor;
        this.area = area;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return String.format("(%s, %d floor and %d rooms, area: %.2l)", this.district, this.roomsCount, this.floor, this.area);
    }
}