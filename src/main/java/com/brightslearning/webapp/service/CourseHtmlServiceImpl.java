package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Course;
import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.CourseRepository;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseHtmlServiceImpl implements CourseHtmlService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String displayAllCourses() {
        Course course = new Course();
        course.setName("2023 Summer");
        Student student1 = new Student();
        student1.setAge(25);
        student1.setName("Erik");
        Student student2 = new Student();
        student1.setAge(46);
        student1.setName("Karlo");
        course.setStudents(Arrays.asList(student1, student2));
        studentRepository.save(student1);
        studentRepository.save(student2);
        courseRepository.save(course);
        return String.format("Course: %s with %d students saved.",
                course.getName(), course.getStudents().size());
    }

    @Override
    public String displayCourse(String name) {
        List<Course> courses = courseRepository.findByName(name);
        StringBuilder courseHtmlBuilder = new StringBuilder();
        for (Course course : courses) {
            courseHtmlBuilder.append(String.format("<h1>Course: %s</h1>", course.getName()));
            appendStudentHtml(courseHtmlBuilder, course.getStudents());
        }
        return courseHtmlBuilder.toString();
    }

    @Override
    public String newCourseHtml() {
        return "newCourseHtml";
    }

    private void appendStudentHtml(StringBuilder courseHtmlBuilder, List<Student> students) {
        for (Student student : students) {
            courseHtmlBuilder.append(String.format("<p>Student: %s, %s, %d, %s, %s</p>", student.getName(),
                    student.getLastName(), student.getAge(), student.getEmail(), student.getOccupation()));
        }
    }
}
