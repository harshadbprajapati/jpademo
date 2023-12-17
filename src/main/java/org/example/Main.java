package org.example;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student();
            student.setId(4);
            student.setStudentName("Anna Smith");

            session.persist(student); //Add the student into the context

            session.getTransaction().commit();

        } finally{
            session.close();
            sessionFactory.close();
        }
    }
}