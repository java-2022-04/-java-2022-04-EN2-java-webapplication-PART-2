package com.brightslearning.webapp.repository;

import com.brightslearning.webapp.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
