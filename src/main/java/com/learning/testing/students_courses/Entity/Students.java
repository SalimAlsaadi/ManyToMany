//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Students")
//public class Students {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "student_id")
//    private int id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    private List<Courses> courses;
//
//
//    public Students() {}
//
//    public Students(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public List<Courses> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Courses> courses) {
//        this.courses = courses;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Students")
//public class Students {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "student_id")
//    private int id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    public Students() {}
//
//    public Students(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package com.learning.testing.students_courses.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    // Many-to-Many relationship with Courses
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Courses> courses;


    // Constructors
    public Students() {}

    public Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    // Override toString for better debugging
    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
