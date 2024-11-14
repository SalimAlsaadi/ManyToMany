package com.learning.testing.students_courses.Controller;

import com.learning.testing.students_courses.Entity.Courses;
import com.learning.testing.students_courses.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Course")
public class CoursesController {

    private CourseService courseService;

    public CoursesController(){}

    @Autowired
    public CoursesController (CourseService courseService){
        this.courseService=courseService;
    }

    @PostMapping("/post_course")
    public String postCourse(@RequestBody Courses courses){
       return courseService.post_course(courses);
    }

}
