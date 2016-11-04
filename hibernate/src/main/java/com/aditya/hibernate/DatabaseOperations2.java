package com.aditya.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseOperations2 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // CREATE
        Session session_1 = sessionFactory.openSession();
        Product p1 = new Product("Desktop PC", 412000);
        Transaction transaction = session_1.beginTransaction();
        session_1.save(p1);
        long id = p1.getId();
        transaction.commit();
        session_1.close();
    }
}
