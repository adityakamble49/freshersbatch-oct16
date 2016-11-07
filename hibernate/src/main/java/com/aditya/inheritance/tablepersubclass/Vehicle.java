package com.aditya.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    public Vehicle() {
    }

    public Vehicle(String name, Integer price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", name=" + name + ", price=" + price
                + "]";
    }

}
