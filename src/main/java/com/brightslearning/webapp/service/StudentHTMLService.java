package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;

public interface StudentHTMLService {
    String displayAllStudents();

    String displayEditStudentForm(Student student);
}
