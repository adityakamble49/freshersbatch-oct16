package com.aditya.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "car")
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
