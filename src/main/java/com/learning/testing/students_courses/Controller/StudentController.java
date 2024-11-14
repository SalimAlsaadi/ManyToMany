package com.learning.testing.students_courses.Controller;

import com.learning.testing.students_courses.Entity.Students;
import com.learning.testing.students_courses.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

    public StudentService studentService;

    public StudentController(){}

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/post_student")
    public ResponseEntity<String> postStudent(@RequestBody Students students){
        return studentService.addStudent(students);
    }

    // Endpoint to get a student with courses
    @GetMapping("/{studentId}")
    public ResponseEntity<Students> getStudentWithCourses(@PathVariable int studentId) {
        return studentService.getStudentWithCourses(studentId);
    }



//   @PutMapping("/add_course_for_student")
//    public ResponseEntity<String> addCourseForStudent(@RequestBody StudentCourse studentCourse){
//        return studentService.addCourseForStudent(studentCourse);
//   }

//   @GetMapping("/get_student_by_ID/{id}")
//    public Students getStudentByID(@PathVariable int id){
//        return studentService.getStudentByID(id);
//   }

}
