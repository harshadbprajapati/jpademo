package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Student;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());
        EntityManager em = emf.createEntityManager(); // It represents the context, manages objects
        try {
            em.getTransaction().begin();

            Student student = new Student();
            student.setId(3);
            student.setStudentName("Will Smith");

            em.persist(student); //Add the student into the context

            em.getTransaction().commit();

        } finally{
            em.close();
        }
    }
}