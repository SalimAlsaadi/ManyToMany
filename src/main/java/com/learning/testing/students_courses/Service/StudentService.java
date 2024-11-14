package com.learning.testing.students_courses.Service;

import com.learning.testing.students_courses.Entity.Courses;
import com.learning.testing.students_courses.Entity.StudentCourse;
import com.learning.testing.students_courses.Entity.Students;
import com.learning.testing.students_courses.Repository.CoursesRepo;
import com.learning.testing.students_courses.Repository.StudentCourseRepo;
import com.learning.testing.students_courses.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    private CoursesRepo coursesRepo;
    private StudentCourseRepo studentCourseRepo;

    public StudentService() {
    }

    @Autowired
    public StudentService(StudentRepo studentRepo, CoursesRepo coursesRepo, StudentCourseRepo studentCourseRepo) {
        this.studentRepo = studentRepo;
        this.coursesRepo = coursesRepo;
        this.studentCourseRepo = studentCourseRepo;
    }



    public ResponseEntity<String> addStudent(Students student) {
        studentRepo.save(student);
        return new ResponseEntity<>("Student name: " + student.getFirstName() + " has been added", HttpStatus.OK);
    }


    // Method to get a student by ID along with their courses
    public ResponseEntity<Students> getStudentWithCourses(int studentId) {
        // Fetch the student by ID
        Optional<Students> student = studentRepo.findById(studentId);

        // If the student is not found, return 404 Not Found
        if (student.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Fetch the list of StudentCourse associations for the given student ID
        List<StudentCourse> studentCourses = studentCourseRepo.findByStudent_Id(studentId);

        if(studentCourses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Extract the courses from the StudentCourse list
        List<Courses> courses = studentCourses.stream()
                .map(StudentCourse::getCourse)
                .collect(Collectors.toList());

        // Get the student entity and set the retrieved courses
        Students foundStudent = student.get();
        foundStudent.setCourses(courses); // Assuming you have a setter for courses in Students entity

        // Return the student with their courses
        return new ResponseEntity<>(foundStudent, HttpStatus.OK);
    }

}
