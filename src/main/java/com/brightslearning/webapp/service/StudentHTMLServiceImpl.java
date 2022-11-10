package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentHTMLServiceImpl implements StudentHTMLService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentHTMLServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String displayAllStudents() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>Students</h1>");
        builder.append("<ul>");
        Iterable<Student> students = studentRepository.findAll();
        appendStudentList(builder, students);
        appendStudentInputForm(builder);
        return builder.toString();
    }

    @Override
    public String displayEditStudentForm(Student student) {
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

    private static void appendStudentList(StringBuilder builder, Iterable<Student> students) {
        for (Student student : students) {
            builder.append("<li>");
            builder.append(String.format("%s , %s ",
                    student.getName(), student.getLastName()));
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
