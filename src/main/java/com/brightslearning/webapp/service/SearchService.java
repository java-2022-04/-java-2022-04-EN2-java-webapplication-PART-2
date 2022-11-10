package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;

import java.util.List;

public interface SearchService {

    List<Student> findStudentByLastName(String lastName);
}
