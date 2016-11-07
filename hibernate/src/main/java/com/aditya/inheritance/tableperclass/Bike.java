package com.aditya.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bike")
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
