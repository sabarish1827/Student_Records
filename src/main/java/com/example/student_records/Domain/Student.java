package com.example.student_records.Domain;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "roll_no", unique = true, nullable = false)
    private int rollNo;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "course", nullable = false)
    private String course;
    @Column(name = "grade")
    private String grade;

    public Student() {
    }

    public Student(int rollNo, String name, String course, String grade) {;
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
