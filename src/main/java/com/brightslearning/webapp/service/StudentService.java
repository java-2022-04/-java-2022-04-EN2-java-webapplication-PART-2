package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;

import java.util.List;

public interface StudentService {
    Student updateStudent(Long id, String name, String lastName, Integer age, String email, String occupation);

    void deleteStudent(Long id);

    List<Student> allStudents();

    Student saveNewStudent(String name, String lastName, Integer age, String email, String occupation);
}
