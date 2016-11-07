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
