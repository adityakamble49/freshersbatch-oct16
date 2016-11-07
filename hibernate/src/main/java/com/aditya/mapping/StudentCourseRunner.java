package com.aditya.mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCourseRunner {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        //addStudent();
        //readStudents();
        //updateStudent();
        deleteStudent();
        sessionFactory.close();
    }

    private static void addStudent() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Set<Student> students = new HashSet<Student>();
        Set<Course> courses = new HashSet<Course>();

        Course javaCourse = new Course("Java", students);
        Course angularCourse = new Course("Angular JS 2", students);
        Course nodeCourse = new Course("Node JS", students);

        courses.add(javaCourse);
        courses.add(angularCourse);
        courses.add(nodeCourse);

        Student aditya = new Student("Aditya Kamble", 123l, courses);

        session.persist(aditya);

        session.getTransaction().commit();
        session.close();
    }

    private static void readStudents() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        List<Student> studentList = query.list();
        for (Student student : studentList) {
            System.out.println(student);
            for (Course course : student.getCourses()) {
                System.out.println(course);
            }
        }
        session.close();
    }

    private static void updateStudent() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.load(Student.class, 1l);
        student.setName("XYZ");
        student.getCourses().forEach(c -> c
                .setCourseName(String.join("", c.getCourseName(), " New !")));
        session.getTransaction().commit();
        session.close();
    }

    private static void deleteStudent() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.load(Student.class, 1l);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }
}
