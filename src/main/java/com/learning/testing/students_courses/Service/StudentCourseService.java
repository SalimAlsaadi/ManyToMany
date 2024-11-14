//package com.learning.testing.students_courses.Service;
//
//import com.learning.testing.students_courses.Entity.Courses;
//import com.learning.testing.students_courses.Entity.StudentCourse;
//import com.learning.testing.students_courses.Entity.StudentCourseId;
//import com.learning.testing.students_courses.Entity.Students;
//import com.learning.testing.students_courses.Repository.CoursesRepo;
//import com.learning.testing.students_courses.Repository.StudentCourseRepo;
//import com.learning.testing.students_courses.Repository.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//@Service
//public class StudentCourseService {
//
//    private StudentCourseRepo studentCourseRepo;
//    private StudentRepo studentRepo;
//    private CoursesRepo coursesRepo;
//
//    public StudentCourseService(){}
//
//    @Autowired
//    public StudentCourseService(StudentCourseRepo studentCourseRepo,StudentRepo studentRepo,CoursesRepo coursesRepo){
//        this.studentCourseRepo=studentCourseRepo;
//        this.studentRepo=studentRepo;
//        this.coursesRepo=coursesRepo;
//    }
//
//
////    public ResponseEntity<String> addCourseForStudent(StudentCourse studentCourse){
////        studentCourseRepo.save(studentCourse);
////        return new ResponseEntity<>("course added for student", HttpStatus.OK);
////    }
//
//    public ResponseEntity<String> addCourseForStudent(StudentCourseId studentCourse) {
//        Optional<Students> student=studentRepo.findById(studentCourse.getStudentId());
//        Optional<Courses> courses=coursesRepo.findById(studentCourse.getCourseId());
//
//        // Check if the student and course exist
//        if (student.isEmpty() || courses.isEmpty()) {
//            return new ResponseEntity<>("Student Not Found or Course Not Found", HttpStatus.NOT_FOUND);
//        } else {
//            StudentCourse studentCourseexsit=new StudentCourse();
//            studentCourseexsit.setStudent(student.get());
//            studentCourseexsit.setCourse(courses.get());
//            studentCourseexsit.setEnrollmentDate(LocalDate.parse("2023-09-24"));
//            // If both exist, save the studentCourse association
//            studentCourseRepo.save(studentCourseexsit);
//            return new ResponseEntity<>("Course for student has been added", HttpStatus.OK);
//        }
//    }
//
//}


package com.learning.testing.students_courses.Service;

import com.learning.testing.students_courses.Entity.Courses;
import com.learning.testing.students_courses.Entity.StudentCourse;
import com.learning.testing.students_courses.Entity.StudentCourseId;
import com.learning.testing.students_courses.Entity.Students;
import com.learning.testing.students_courses.Repository.CoursesRepo;
import com.learning.testing.students_courses.Repository.StudentCourseRepo;
import com.learning.testing.students_courses.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StudentCourseService {

    private final StudentCourseRepo studentCourseRepo;
    private final StudentRepo studentRepo;
    private final CoursesRepo coursesRepo;

    @Autowired
    public StudentCourseService(StudentCourseRepo studentCourseRepo, StudentRepo studentRepo, CoursesRepo coursesRepo) {
        this.studentCourseRepo = studentCourseRepo;
        this.studentRepo = studentRepo;
        this.coursesRepo = coursesRepo;
    }

    public ResponseEntity<String> addCourseForStudent(StudentCourseId studentCourseId, LocalDate enrollmentDate) {
        Optional<Students> student = studentRepo.findById(studentCourseId.getStudentId());
        Optional<Courses> course = coursesRepo.findById(studentCourseId.getCourseId());
        if (student.isEmpty() || course.isEmpty()) {
            return new ResponseEntity<>("Student or Course not found", HttpStatus.NOT_FOUND);
        }

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(studentCourseId);
        studentCourse.setStudent(student.get());
        studentCourse.setCourse(course.get());
        studentCourse.setEnrollmentDate(enrollmentDate);

        studentCourseRepo.save(studentCourse);
        return new ResponseEntity<>("Course for student has been added", HttpStatus.OK);
    }


    public ResponseEntity<String> deleteCourseFromStudent(StudentCourseId studentCourseId) {
        Optional<Students> student = studentRepo.findById(studentCourseId.getStudentId());
        Optional<Courses> course = coursesRepo.findById(studentCourseId.getCourseId());

        if (student.isEmpty() || course.isEmpty()) {
            return new ResponseEntity<>("Student or Course not found", HttpStatus.NOT_FOUND);
        }

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourse(course.get());
        studentCourse.setStudent(student.get());
        Optional<StudentCourse> get = studentCourseRepo.findByStudent_IdAndCourse_Id(student.get().getId(), course.get().getId());

        if (get.isPresent()) {
            studentCourseRepo.delete(get.get());
            return new ResponseEntity<>("course " + course.get().getCourseName() + " has been deleted from student " + student.get().getFirstName(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
        }

    }

}

