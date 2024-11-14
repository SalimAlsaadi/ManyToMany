package com.learning.testing.students_courses.Service;

import com.learning.testing.students_courses.Entity.Courses;
import com.learning.testing.students_courses.Repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CoursesRepo coursesRepo;

    public CourseService(){}
    @Autowired
    public CourseService(CoursesRepo coursesRepo){
        this.coursesRepo=coursesRepo;
    }

   public String post_course(Courses courses){
        coursesRepo.save(courses);
        return "Course: "+courses.getCourseName()+" has been added";
   }
}
