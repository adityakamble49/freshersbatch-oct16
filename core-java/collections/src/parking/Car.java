package parking;

public class Car {

    private String ownerName;
    private String carModel;
    private String carNumber;
    private long ownerMobileNo;
    private String ownerAddress;

    public Car(String ownerName, String carModel, String carNumber,
            long ownerMobileNo, String ownerAddress) {
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.ownerMobileNo = ownerMobileNo;
        this.ownerAddress = ownerAddress;
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
