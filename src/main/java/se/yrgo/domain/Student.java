package se.yrgo.domain;

import jakarta.persistence.*;
import jakarta.persistence.Column;

@Entity
public class Student {
    private String enrollmentID;
    private String name;
    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutor tutor; // This will become a class soon

    @Column (name="NUM_COURSES")
    private Integer numberOfCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     //This line is optional
    private int id;

    public Student() {}

    public Student(String name, String enrollmentID) {
        this.name = name;
        this.enrollmentID = enrollmentID;
    }

    public Student(String name) {
    	this.name = name;
        this.numberOfCourses = 10;
    }

    public String getEnrollmentID() { return enrollmentID; }

    public String getName() { return name; }

    public Integer getNumberOfCourses() { return numberOfCourses; }

    public int getId() { return id; }

    public void setEnrollmentID(String enrollmentID) { this.enrollmentID = enrollmentID; }

    public void setName(String name) { this.name = name; }

    public void setNumberOfCourses(Integer numberOfCourses) { this.numberOfCourses = numberOfCourses; }

    public void setId(int id) { this.id = id; }

    //public void allocateTutor(Tutor tutor) { this.tutor = tutor; }
    //public String getTutorName() { return this.tutor.getName(); }
    //public Tutor getTutor() { return tutor; }

    @Override
    public String toString() {
        return "name: " + name + ", tutor name: " + tutor.getName();
    }
}
