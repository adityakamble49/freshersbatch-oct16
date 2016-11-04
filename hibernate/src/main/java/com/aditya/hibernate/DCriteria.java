package com.aditya.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DCriteria {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        getTotalSalary();
        orderEmployees();
        orderEmployeesHQL();
        groupEmployees();
        getAvgSalary();
        employeeMoreThan10();

        sessionFactory.close();

    }

    private static void getTotalSalary() {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.sum("salary"));
        Object totalSalary = criteria.uniqueResult();
        System.out.println(totalSalary);
        session.close();

    }

    private static void orderEmployees() {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.addOrder(Order.asc("salary"));
        List employeeList = criteria.list();
        System.out.println(employeeList);
        session.close();
    }

    private static void orderEmployeesHQL() {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Employee order by salary");
        List employeeList = query.list();
        System.out.println(employeeList);
        session.close();
    }

    private static void groupEmployees() {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(
                Projections.projectionList().add(Projections.count("name"))
                        .add(Projections.groupProperty("role")));
        List<Object[]> list = criteria.list();
        for (Object[] single : list) {
            System.out.println(single[1] + ":" + single[0]);
        }
        session.close();
    }

    private static void getAvgSalary() {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.avg("salary"));
        Object avgSalary = criteria.uniqueResult();
        System.out.println(avgSalary);
        session.close();

    }

    private static void employeeMoreThan10() {

        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.gt("salary", 10000));
        List employeeList = criteria.list();
        System.out.println(employeeList);
        session.close();

    }

    public static void listEmployees() {

        Session session = sessionFactory.openSession();

        Query selectQuery = session.createQuery("from Product");
        List<Product> plist = selectQuery.list();
        System.out.println(plist);
        session.close();
    }
}
