package org.example.entities;
import jakarta.persistence.*;

@Entity
public class Student {
//    @TableGenerator(name="studentIdGenerator", table="student_id_generator",
//        pkColumnName="student_id", pkColumnValue="student_id_value",
//        allocationSize = 1)
//    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator="studentIdGenerator")
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
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
