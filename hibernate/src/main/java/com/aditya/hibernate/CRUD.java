package com.aditya.hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUD {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        insertUsingSQL();

    }

    public static void insertUsingSQL() {

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        String sqlInsert = "INSERT INTO PRODUCT_MASTER VALUES(:id,:name,:cost)";
        SQLQuery sqlQuery = session.createSQLQuery(sqlInsert);
        sqlQuery.setInteger("id", 1);
        sqlQuery.setString("name", "Android");
        sqlQuery.setDouble("cost", 50000);
        int update = sqlQuery.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Inserted " + update);
    }
}
