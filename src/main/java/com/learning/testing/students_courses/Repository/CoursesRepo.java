package com.learning.testing.students_courses.Repository;

import com.learning.testing.students_courses.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses, Integer> {
}
