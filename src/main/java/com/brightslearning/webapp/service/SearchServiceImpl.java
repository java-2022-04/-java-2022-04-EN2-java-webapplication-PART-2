package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }
}
