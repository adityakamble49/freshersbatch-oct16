package com.aditya.inheritance.single;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleMain {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehicle vehicle = new Vehicle("Vehicle 1", 10000);
        Car car = new Car("Car 1", 15000, "Diesel");
        Bike bike = new Bike("Bike 1", 25440, 50);

        session.save(vehicle);
        session.save(car);
        session.save(bike);

        session.getTransaction().commit();
        session.close();

    }
}
