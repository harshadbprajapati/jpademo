package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student1 = session.find(Student.class, 1);
            System.out.println("Retrieving student " + student1);
            student1.setStudentName("Tom Cruise");
            System.out.println("Retrieving student " + student1);
            session.getTransaction().commit();
            student1.setStudentName("Tomkumar Cruise");
        } finally{
            session.close();
            sessionFactory.close();
        }
    }
}