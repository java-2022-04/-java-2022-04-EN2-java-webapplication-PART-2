package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Course;
import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentHTMLServiceImpl implements StudentHTMLService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentHTMLServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String studentListAsHtml() {
        Iterable<Student> students = studentRepository.findAll();
        return studentListAsHtml(students);
    }

    public String studentListAsHtml(Iterable<Student> students) {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>Students</h1>");
        builder.append("<ul>");
        appendStudentList(builder, students);
        appendStudentInputForm(builder);
        return builder.toString();
    }

    @Override
    public String studentEditFormHtml(String id) {
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(id));
        if (studentOptional.isPresent()) return studentEditFormHtml(studentOptional.get());
        return String.format("<h1>Student with id: %s does not exist</h1>", id);
    }

    @Override
    public String studentEditFormHtml(Student student) {
        StringBuilder builder = new StringBuilder();
        builder.append("<form action='/update' method='POST'>");
        builder.append(String.format("<input name='id' value='%d'></input>", student.getId()));
        builder.append(String.format("<input name='name' value='%s'></input>", student.getName()));
        builder.append(String.format("<input name='lastName' value='%s'></input>", student.getLastName()));
        builder.append(String.format("<input name='age' value='%d'></input>", student.getAge()));
        builder.append(String.format("<input name='email' value='%s'></input>", student.getEmail()));
        builder.append(String.format("<input name='occupation' value='%s'></input>", student.getOccupation()));
        builder.append("<input type='submit'></input>");
        builder.append("</form>");
        return builder.toString();
    }

    @Override
    public String newStudentCreatedAsHtml(String name, String lastName, Integer age, String email, String occupation) {
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setAge(age);
        student.setEmail(email);
        student.setOccupation(occupation);
        studentRepository.save(student);
        return String.format("<h2>Student %s %s has been saved.</h2>",
                name, lastName);
    }


    @Override
    public String studentHasBeenUpdatedAsHtml(Student updatedStudent) {
        return String.format("<h2>Student %s %s has been saved.</h2>",
                updatedStudent.getName(), updatedStudent.getLastName());
    }

    @Override
    public String studentHasBeenRemovedAsHtml(Long id) {
        return String.format("<h2>Student with id: %s has been removed.</h2>%s",
                id, studentListAsHtml());
    }

    private static void appendStudentList(StringBuilder builder, Iterable<Student> students) {
        for (Student student : students) {
            builder.append("<li>");
            Course course = student.getCourse();
            builder.append(String.format("%s , %s, %s ",
                    student.getName(), student.getLastName(),
                    course == null ? "Not assigned to a Course yet" : course.getName()));
            Long studentId = student.getId();
            appendEditLinks(builder, studentId);
            builder.append("</li>");
        }
        builder.append("</ul>");
    }

    private static void appendEditLinks(StringBuilder builder, Long studentId) {
        builder.append(
                String.format(" <a href='/edit?id=%s'>edit</a> <a href='/delete?id=%s'>delete</a>",
                        studentId, studentId));
    }


    private static void appendStudentInputForm(StringBuilder builder) {
        builder.append("<form action='/add' method='POST'>");
        builder.append("<input name='name' value='name'></input>");
        builder.append("<input name='lastName' value='lastName'></input>");
        builder.append("<input name='age' value='20'></input>");
        builder.append("<input name='email' value='email'></input>");
        builder.append("<input name='occupation' value='occupation'></input>");
        builder.append("<input type='submit'></input>");
        builder.append("</form>");
    }
}
