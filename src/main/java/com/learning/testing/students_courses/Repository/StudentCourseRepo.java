package com.learning.testing.students_courses.Repository;

import com.learning.testing.students_courses.Entity.Courses;
import com.learning.testing.students_courses.Entity.StudentCourse;
import com.learning.testing.students_courses.Entity.StudentCourseId;
import com.learning.testing.students_courses.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, StudentCourseId> {
    boolean existsByStudentAndCourse(Students student, Courses course);
    List<StudentCourse> findByStudent_Id(int studentId);

    Optional<StudentCourse> findByStudent_IdAndCourse_Id(int studentId, int courseId);

}
