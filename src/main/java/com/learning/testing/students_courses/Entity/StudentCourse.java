//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "students_courses")
//public class StudentCourse implements Serializable {
//
//    @EmbeddedId
//    private StudentCourseId id;
//
//    @ManyToOne
//    @MapsId("studentId")
//    @JoinColumn(name = "student_id")
//    private Students student;
//
//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    private Courses course;
//
//    @Column(name = "enrollment_date")
//    private LocalDate enrollmentDate;
//
//    public StudentCourse() {}
//
//    public StudentCourse(Students student, Courses course, LocalDate enrollmentDate) {
//        this.student = student;
//        this.course = course;
//        this.enrollmentDate = enrollmentDate;
//        this.id = new StudentCourseId(student.getId(), course.getId());
//    }
//
//    public StudentCourseId getId() {
//        return id;
//    }
//
//    public void setId(StudentCourseId id) {
//        this.id = id;
//    }
//
//    public Students getStudent() {
//        return student;
//    }
//
//    public void setStudent(Students student) {
//        this.student = student;
//    }
//
//    public Courses getCourse() {
//        return course;
//    }
//
//    public void setCourse(Courses course) {
//        this.course = course;
//    }
//
//    public LocalDate getEnrollmentDate() {
//        return enrollmentDate;
//    }
//
//    public void setEnrollmentDate(LocalDate enrollmentDate) {
//        this.enrollmentDate = enrollmentDate;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "students_courses")
//public class StudentCourse implements Serializable {
//
//    @EmbeddedId
//    private StudentCourseId id;
//
//    @ManyToOne
//    @MapsId("studentId")
//    @JoinColumn(name = "student_id")
//    private Students student;
//
//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    private Courses course;
//
//    @Column(name = "enrollment_date")
//    private LocalDate enrollmentDate;
//
//    public StudentCourse() {}
//
//    public StudentCourse(Students student, Courses course, LocalDate enrollmentDate) {
//        this.student = student;
//        this.course = course;
//        this.enrollmentDate = enrollmentDate;
//        this.id = new StudentCourseId(student.getId(), course.getId());
//    }
//
//    public StudentCourseId getId() {
//        return id;
//    }
//
//    public void setId(StudentCourseId id) {
//        this.id = id;
//    }
//
//    public Students getStudent() {
//        return student;
//    }
//
//    public void setStudent(Students student) {
//        this.student = student;
//    }
//
//    public Courses getCourse() {
//        return course;
//    }
//
//    public void setCourse(Courses course) {
//        this.course = course;
//    }
//
//    public LocalDate getEnrollmentDate() {
//        return enrollmentDate;
//    }
//
//    public void setEnrollmentDate(LocalDate enrollmentDate) {
//        this.enrollmentDate = enrollmentDate;
//    }
//}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.learning.testing.students_courses.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "students_courses")
public class StudentCourse implements Serializable {

    @EmbeddedId
    private StudentCourseId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Students student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Courses course;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    public StudentCourse() {}

    public StudentCourse(Students student, Courses course, LocalDate enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.id = new StudentCourseId(student.getId(), course.getId());
    }

    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
        this.id = id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }


}
