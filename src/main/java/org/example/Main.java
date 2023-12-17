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
        Session session1 = sessionFactory.openSession();
        Student student1=null;
        Session session2=null;

        try {
            session1.beginTransaction();
            student1 = session1.get(Student.class, 2);
            session1.getTransaction().commit();
            session1.close();
            System.out.println("Retrieving student " + student1);

            student1.setStudentName("Tomkumar Cruise");
            session2 = sessionFactory.openSession();
            session2.beginTransaction();
            session2.merge(student1);
            session2.getTransaction().commit();

        } finally{
            session2.close();
            sessionFactory.close();
        }
    }
}