package com.brightslearning.webapp.repository;

import com.brightslearning.webapp.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
