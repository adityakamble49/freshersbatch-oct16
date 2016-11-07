package com.aditya.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Bike extends Vehicle {

    @Column(name = "mileage")
    private Integer mileage;

    public Bike(String name, Integer price, Integer mileage) {
        super(name, price);
        this.mileage = mileage;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Bike [mileage=" + mileage + "]";
    }

}
