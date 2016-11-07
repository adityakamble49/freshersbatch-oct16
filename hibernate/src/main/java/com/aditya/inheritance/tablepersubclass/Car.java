package com.aditya.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends Vehicle {

    @Column(name = "fuel_type")
    private String fuelType;

    public Car(String name, Integer price, String fuelType) {
        super(name, price);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car [fuelType=" + fuelType + "]";
    }

}
