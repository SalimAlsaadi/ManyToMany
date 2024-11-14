//package com.learning.testing.students_courses.Controller;
//
//import com.learning.testing.students_courses.Entity.StudentCourse;
//import com.learning.testing.students_courses.Entity.StudentCourseId;
//import com.learning.testing.students_courses.Service.StudentCourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/studentCourse")
//public class StudentCourseController {
//
//    public StudentCourseService studentCourseService;
//
//    @Autowired
//    public StudentCourseController(StudentCourseService studentCourseService){
//        this.studentCourseService=studentCourseService;
//    }
//
//
//    @PostMapping("/addCourseForStudent")
//    public ResponseEntity<String> addCourseForStudent(@RequestBody StudentCourseId studentCourse ){
//        return studentCourseService.addCourseForStudent(studentCourse);
//    }
//}

package com.learning.testing.students_courses.Controller;

import com.learning.testing.students_courses.Entity.StudentCourseId;
import com.learning.testing.students_courses.Service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/studentCourse")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/addCourseForStudent")
    public ResponseEntity<String> addCourseForStudent(@RequestBody Map<String, Object> request) {
        // Extracting the studentId, courseId, and enrollmentDate from the request
        int studentId = (int) request.get("studentId");
        int courseId = (int) request.get("courseId");
        LocalDate enrollmentDate = LocalDate.parse((String) request.get("enrollmentDate"));

        // Creating StudentCourseId object
        StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId);

        // Calling the service to add the course for the student
        return studentCourseService.addCourseForStudent(studentCourseId, enrollmentDate);
    }

    @DeleteMapping("/deleteCourseFromStudent")
    public ResponseEntity<String> deleteCourseFromStudent(@RequestBody StudentCourseId studentCourseId){
        return studentCourseService.deleteCourseFromStudent(studentCourseId);
    }
}
