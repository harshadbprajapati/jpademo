package org.example.entities;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//public class Student {
//
//    @TableGenerator(name="studentIdGenerator", table = "student_id_generator",
//            pkColumnName = "student_id", pkColumnValue = "student_id_value",
//            allocationSize = 1
//    )
//    @Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "studentIdGenerator")
//    private long id;
//
//    @Column(name = "student_name")
//    private String studentName;
//
//    public long getId() {
//        return id;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//}


//import jakarta.persistence.*;
//
//        import java.util.Date;
//
//@Entity
//public class Student {
//    @Id
//    private long id;
//
//    @Column(name = "student_name")
//    private String studentName;
//
//    @Column(name = "roll_number", nullable = false)
//    private int rollNumber;
//
//    @Temporal(TemporalType.DATE)
//    private Date birthDate;
//
//    @Transient
//    @Column(name = "full_name", nullable = false)
//    private String fullName;
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public int getRollNumber() {
//        return rollNumber;
//    }
//
//    public void setRollNumber(int rollNumber) {
//        this.rollNumber = rollNumber;
//    }
//}

