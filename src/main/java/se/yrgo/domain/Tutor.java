package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
//@Table(name="TBL_NAME")
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;
    @JoinColumn(name="TUTOR_FK")
    @OneToMany
    private List<Student> teachingGroup;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Tutor() {}

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        //this.teachingGroup = new HashSet<Student>();
        this.teachingGroup = new ArrayList<Student>();     //Maybe add String?
    }

    public String getTutorId() { return tutorId; }

    public String getName() { return name; }

    public int getSalary() { return salary; }

    // A method that can get the collection.
    public List<Student> getTeachingGroup() {
        List<Student> unmodifiable = Collections.unmodifiableList(this.teachingGroup);
        return unmodifiable;
    }

    // A method that can add objects (students) to the collection.
    public void addStudentToTeachingGroup(Student newStudent) { this.teachingGroup.add(newStudent); }

}
