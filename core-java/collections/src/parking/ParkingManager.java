package parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ParkingManager {

    private static ParkingManager parkingManager;

    private Map<String, Car> carMap = new HashMap<String, Car>();
    private Map<String, Location> locationMap = new HashMap<String, Location>();

    private int currentFloor = 0;
    private int currentSection = 0;
    private int currentAreaNo = 0;

    public static ParkingManager getInstance() {
        if (parkingManager == null) {
            parkingManager = new ParkingManager();
        }
        return parkingManager;
    }

    public void addCar(Car car) {
        carMap.put(car.getCarNumber(), car);
        locationMap.put(car.getCarNumber(), getNewParkingLocation());
    }

    private Location getNewParkingLocation() {
        Random random = new Random();

        int floor = random.nextInt(2);
        int section = random.nextInt(3);
        int areaNo = random.nextInt(19);

        Location carLocation = new Location(floor, section, areaNo);
        return carLocation;
    }

    public Location getLocation(String carNo) {
        Location carLocation = locationMap.get(carNo);
        return carLocation;
    }

    public void removeCar(String carNo) {
        carMap.remove(carNo);
    }
}
