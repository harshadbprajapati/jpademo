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
        Student student1=null;

        try {
            session.beginTransaction();
            student1 = new Student();
            student1.setStudentName("Tom Cruise");
            session.persist(student1);
            session.getTransaction().commit();
        } finally{
            System.out.println("Retrieving student " + student1);
            session.close();
            sessionFactory.close();
        }
    }
}