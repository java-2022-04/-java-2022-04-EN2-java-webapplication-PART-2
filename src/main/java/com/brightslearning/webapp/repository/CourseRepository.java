package com.brightslearning.webapp.repository;

import com.brightslearning.webapp.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByName(String name);
}
