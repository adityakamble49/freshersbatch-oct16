package com.aditya.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseOperations {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // CREATE
        Session session_1 = sessionFactory.openSession();
        Product p1 = new Product("Desktop PC", 41000);
        Transaction transaction = session_1.beginTransaction();
        session_1.save(p1);
        long id = p1.getId();
        transaction.commit();
        session_1.close();

        // READ
        Session session_2 = sessionFactory.openSession();
        Query selectQuery = session_2.createQuery("from Product");
        List<Product> plist = selectQuery.list();
        System.out.println(plist);
        session_2.close();

        // UPDATE
        Session session_3 = sessionFactory.openSession();
        Transaction transaction2 = session_3.beginTransaction();
        Product p2 = session_3.get(Product.class, id);
        p2.setName("Laptop");
        session_3.update(p2);
        transaction2.commit();
        session_3.close();

        // DELETE
        Session session_4 = sessionFactory.openSession();
        Transaction transaction3 = session_4.beginTransaction();
        Product p3 = session_4.get(Product.class, id - 1);
        // session_4.delete(p3);
        // transaction3.commit();
        session_4.close();
    }
}
