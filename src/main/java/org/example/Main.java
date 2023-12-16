package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Student;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");
        EntityManager em = emf.createEntityManager(); // It represents the context, manages objects
        try {
            em.getTransaction().begin();

            Student student = new Student();
            student.setId(1);
            student.setStudentName("Tom Cruise");

//            student.setId(2);
//            student.setStudentName("Tom Smith");

            em.persist(student); //Add the student into the context

            em.getTransaction().commit();

        } finally{
            em.close();
        }
    }
}
