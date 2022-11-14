package com.brightslearning.webapp.service;

import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student updateStudent(Long id, String name, String lastName, Integer age, String email, String occupation) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student = studentOptional.orElseThrow();
        student.setName(name);
        student.setLastName(lastName);
        student.setAge(age);
        student.setEmail(email);
        student.setOccupation(occupation);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> allStudents() {
        Iterable<Student> iterable = studentRepository.findAll();
        List<Student> students = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        return students;
    }

    @Override
    public Student saveNewStudent(String name, String lastName, Integer age, String email, String occupation) {
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setAge(age);
        student.setEmail(email);
        student.setOccupation(occupation);
        studentRepository.save(student);
        return student;
    }
}
