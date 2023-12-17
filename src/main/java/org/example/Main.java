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

            Student student1 = new Student();
            student1.setStudentName("Tom Cruise");
//            student1.setStudentName("Will Smith");
//            student1.setStudentName("Arnold Schwarzenegger");

            Student student2 = new Student();
            student2.setStudentName("Nicolas Cage");
//            student2.setStudentName("John Travolta");
//            student2.setStudentName("Sylvester Stallone");

            session.persist(student1);
            session.persist(student2);

            session.getTransaction().commit();

        } finally{
            session.close();
            sessionFactory.close();
        }
    }
}
