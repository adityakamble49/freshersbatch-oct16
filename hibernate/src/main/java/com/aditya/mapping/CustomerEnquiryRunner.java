package com.aditya.mapping;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerEnquiryRunner {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        // addCustomer();
        // readCustomers();
        // updateCustomers();
        deleteCustomers();
        sessionFactory.close();
    }

    private static void addCustomer() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Enquiry enquiry = new Enquiry("This is an enquiry 2");
        Customer customer = new Customer("ABC", enquiry);
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    private static void readCustomers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        System.out.println(customerList);
        session.close();
    }

    private static void updateCustomers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.load(Customer.class, 3l);
        customer.setName("XYZ");
        customer.getEnquiry().setDetails("Updated Enquiry");
        session.getTransaction().commit();
        session.close();
    }

    private static void deleteCustomers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.load(Customer.class, 3l);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }
}
