package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Course;
import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.CourseRepository;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CourseHtmlServiceImpl implements CourseHtmlService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String displayAllCourses() {
        Course course = new Course();
        course.setName("2022 Autumn");
        Student student1 = new Student();
        student1.setAge(25);
        student1.setName("Hugo");
        Student student2 = new Student();
        student1.setAge(46);
        student1.setName("Sam");
        course.setStudents(Arrays.asList(student1, student2));
        studentRepository.save(student1);
        studentRepository.save(student2);
        courseRepository.save(course);
        return String.format("Course: %s with %d students saved.",
                course.getName(), course.getStudents().size());
    }
}
