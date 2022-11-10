package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;

public interface StudentService {
    Student updateStudent(Long id, String name, String lastName, Integer age, String email, String occupation);

    void deleteStudent(Long id);
}
