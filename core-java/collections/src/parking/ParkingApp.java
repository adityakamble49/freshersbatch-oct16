package parking;

public class ParkingApp {

    public static void main(String[] args) {

        ParkingManager.getInstance().addCar(
                new Car("akshay", "swift", "mh14", 123456789, "android"));
        ParkingManager.getInstance().addCar(
                new Car("akshay", "swift", "mh15", 123456789, "android"));
        ParkingManager.getInstance().addCar(
                new Car("akshay", "swift", "mh16", 123456789, "android"));

        Location l1 = ParkingManager.getInstance().getLocation("mh14");
        Location l2 = ParkingManager.getInstance().getLocation("mh15");
        Location l3 = ParkingManager.getInstance().getLocation("mh16");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }

}
