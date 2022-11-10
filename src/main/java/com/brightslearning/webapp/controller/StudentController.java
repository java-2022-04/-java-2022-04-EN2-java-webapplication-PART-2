package com.brightslearning.webapp.controller;

import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import com.brightslearning.webapp.service.StudentHTMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class StudentController {

    private StudentRepository studentRepository;
    private StudentHTMLService studentsHtmlService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentHTMLService studentsHtmlService) {
        this.studentRepository = studentRepository;
        this.studentsHtmlService = studentsHtmlService;
    }

    @GetMapping("/students")
    @ResponseBody
    public String displayAllStudents() {
        return studentsHtmlService.displayAllStudents();
    }
    @PostMapping("/add")
    @ResponseBody
    public String addStudent(@RequestParam String name,
                              @RequestParam String lastName,
                              @RequestParam Integer age,
                              @RequestParam String email,
                              @RequestParam String occupation) {
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setAge(age);
        student.setEmail(email);
        student.setOccupation(occupation);
        studentRepository.save(student);
        return String.format("<h2>Student %s %s has been saved.</h2>%s",
                name, lastName, studentsHtmlService.displayAllStudents());
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateStudent(@RequestParam Long id,
                                @RequestParam String name,
                              @RequestParam String lastName,
                              @RequestParam Integer age,
                              @RequestParam String email,
                              @RequestParam String occupation) {


        Optional<Student> studentOptional = studentRepository.findById(id);
        String studentUpdateForm;
        //nicer way here
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(name);
            student.setLastName(lastName);
            student.setAge(age);
            student.setEmail(email);
            student.setOccupation(occupation);
            studentRepository.save(student);
            return String.format("<h2>Student %s %s has been saved.</h2>%s",
                    name, lastName, studentsHtmlService.displayAllStudents());
        } else {
            return String.format("No student with id: %s found", id);
        }

    }
    @GetMapping("/edit")
    @ResponseBody
    public String editStudent(@RequestParam String id) {
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(id));
        String studentEditForm;
        //nicer way here
        if (studentOptional.isPresent()) {
            studentEditForm = studentsHtmlService.displayEditStudentForm(studentOptional.get());
        } else {
            studentEditForm = String.format("No student with id: %s found", id);
        }
        return studentEditForm;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteStudent(@RequestParam Long id) {
        studentRepository.deleteById(id);
        return String.format("<h2>Student has been removed.</h2>%s",
                studentsHtmlService.displayAllStudents());
    }


}
