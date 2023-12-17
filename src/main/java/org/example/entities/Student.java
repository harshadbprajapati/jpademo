package org.example.entities;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "student_name")
    private String studentName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
