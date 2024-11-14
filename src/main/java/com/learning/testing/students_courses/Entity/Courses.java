//package com.learning.testing.students_courses.Entity;
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Courses")
//public class Courses {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "course_id")
//    private int id;
//
//    @Column(name = "name")
//    private String courseName;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
//    private List<Students> students;
//
//
//    public Courses() {}
//
//    public Courses(String courseName) {
//        this.courseName = courseName;
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
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//
//    public List<Students> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Students> students) {
//        this.students = students;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Courses")
//public class Courses {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "course_id")
//    private int id;
//
//    @Column(name = "name")
//    private String courseName;
//
//    public Courses() {}
//
//    public Courses(String courseName) {
//        this.courseName = courseName;
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
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package com.learning.testing.students_courses.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class  Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "name")
    private String courseName;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST
    })
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
    private List<Students> students;

    public Courses() {}

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
