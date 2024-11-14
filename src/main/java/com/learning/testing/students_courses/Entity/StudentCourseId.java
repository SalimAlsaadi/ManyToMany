//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class StudentCourseId implements Serializable {
//
//    private int studentId;
//    private int courseId;
//
//    public StudentCourseId() {}
//
//    public StudentCourseId(int studentId, int courseId) {
//        this.studentId = studentId;
//        this.courseId = courseId;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//}


//package com.learning.testing.students_courses.Entity;
//
//import jakarta.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class StudentCourseId implements Serializable {
//
//    private int studentId;
//    private int courseId;
//
//    public StudentCourseId() {}
//
//    public StudentCourseId(int studentId, int courseId) {
//        this.studentId = studentId;
//        this.courseId = courseId;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StudentCourseId that = (StudentCourseId) o;
//        return studentId == that.studentId && courseId == that.courseId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(studentId, courseId);
//    }
//}


package com.learning.testing.students_courses.Entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentCourseId implements Serializable {

    private int studentId;
    private int courseId;

    public StudentCourseId() {}

    public StudentCourseId(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseId that = (StudentCourseId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
