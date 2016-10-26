package parking;

public class Location {

    private int floor;
    private int section;
    private int areaNumber;

    public Location(int floor, int section, int areaNumber) {
        this.floor = floor;
        this.section = section;
        this.areaNumber = areaNumber;
    }

    @Override
    public String toString() {
        return "Floor : " + floor + " : " + section + " : " + areaNumber;
    }
}
