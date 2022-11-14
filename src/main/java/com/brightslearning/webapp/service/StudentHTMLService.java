package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;

public interface StudentHTMLService {
    String studentListAsHtml();

    String studentEditFormHtml(Student student);
    String studentEditFormHtml(String id);

    String newStudentCreatedAsHtml(Student student);

    String studentHasBeenUpdatedAsHtml(Student updatedStudent);

    String studentHasBeenRemovedAsHtml(Long id);

    String studentListAsHtml(Iterable<Student> students);
}
