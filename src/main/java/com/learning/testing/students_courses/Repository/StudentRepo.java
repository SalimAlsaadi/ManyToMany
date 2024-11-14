package com.learning.testing.students_courses.Repository;

import com.learning.testing.students_courses.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students, Integer> {
}
