package org.example;

import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Student.class);
        SessionFactory sessionFactory = config.buildSessionFactory();

        StudentDAO studentDAO = new StudentDAOImpl(sessionFactory);

        Student student1= new Student();
        student1.setStudentName("Tom Cruise");
        Student student2= new Student();
        student2.setStudentName("Will Smith");

        System.out.println("Adding student " + student1);
        System.out.println("Adding student " + student2);
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);

        List<Student> students = studentDAO.getAllStudents();
        System.out.println("Students: "+students.toString());

        Student studentToUpdate = studentDAO.getStudentById(1);
        System.out.println("Updating student " + studentToUpdate);
        if(studentToUpdate!=null){
            studentToUpdate.setStudentName("Tomkumar Cruise");
            studentDAO.updateStudent(studentToUpdate);
        }
        Student updatedStudent = studentDAO.getStudentById(1);
        System.out.println("Updated student = "+updatedStudent);

        studentDAO.deleteStudent(2);
        System.out.println("Deleting student with id = "+ 2);
        List<Student> studentsAfterDelete = studentDAO.getAllStudents();
        System.out.println("Students: "+studentsAfterDelete.toString());

        sessionFactory.close();
    }
}

// State transition
//package org.example;
//
//import org.example.entities.Student;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session1 = sessionFactory.openSession();
//        Student student1=null;
//        Session session2=null;
//
//        try {
//            session1.beginTransaction();
//            student1 = session1.get(Student.class, 2);
//            session1.getTransaction().commit();
//            session1.close();
//            System.out.println("Retrieved Student = " + student1);
//
//            student1.setStudentName("Tomkumar Cruise");
//            session2 = sessionFactory.openSession();
//            session2.beginTransaction();
//            session2.merge(student1);
//            session2.getTransaction().commit();
//
//        } finally{
//            session2.close();
//            sessionFactory.close();
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            Student student1 = new Student();
//            student1.setStudentName("Tom Cruise");
//
//            session.persist(student1);
//
//            student1.setStudentName("Tomkumar Cruise");
//
//            session.getTransaction().commit();
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//    }
//}

//import org.example.entities.Student;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//
//            session.beginTransaction();
//
//            Student student1 = new Student();
//            student1.setStudentName("Tom Cruise");
//
//            Student student2 = new Student();
//            student2.setStudentName("Will Smith");
//
//            session.persist(student1);
//            session.persist(student2);
//
//            session.getTransaction().commit();
//
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//    }
//}

/*
Hibernate hbm2ddl.auto
 */
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
//        SessionFactory sessionFactory = config.buildSessionFactory();
////        sessionFactory.close();
//    }
//}

/*
Hibernate
 */
//import org.example.entities.Student;
//        import org.hibernate.Session;
//        import org.hibernate.SessionFactory;
//        import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.entities.Student.class);
////        config.configure();
//        // local SessionFactory bean created
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            Student student = new Student();
//            student.setId(5);
//            student.setStudentName("Maggie Smith");
//
//            session.persist(student); //Add the student into the context
//
//            session.getTransaction().commit();
//
//        } finally{
//            session.close();
//            sessionFactory.close();
//        }
//    }
//}

/*
JPA
 */
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import org.example.entities.Student;
//import org.example.persistence.CustomPersistenceUnitInfo;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//
//import java.util.HashMap;

//public class Main {
//    public static void main(String[] args) {
//
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");
//
//        EntityManagerFactory emf = new HibernatePersistenceProvider()
//                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());
//        EntityManager em = emf.createEntityManager(); // It represents the context, manages objects
//        try {
//            em.getTransaction().begin();
//
//            Student student = new Student();
//            student.setId(3);
//            student.setStudentName("Will Smith");
//
//            em.persist(student); //Add the student into the context
//
//            em.getTransaction().commit();
//
//        } finally{
//            em.close();
//        }
//    }
//}