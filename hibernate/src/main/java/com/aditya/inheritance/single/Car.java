package com.aditya.inheritance.single;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id") ),
        @AttributeOverride(name = "name", column = @Column(name = "name") ),
        @AttributeOverride(name = "price", column = @Column(name = "price") ), })
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
