package com.brightslearning.webapp.repository;

import com.brightslearning.webapp.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastName);
    List<Student> findByNameAndLastName(String name, String lastName);
}
