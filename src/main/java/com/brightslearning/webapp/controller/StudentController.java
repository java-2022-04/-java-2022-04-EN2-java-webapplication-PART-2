package com.brightslearning.webapp.controller;

import com.brightslearning.webapp.entity.Student;
import com.brightslearning.webapp.repository.StudentRepository;
import com.brightslearning.webapp.service.SearchService;
import com.brightslearning.webapp.service.StudentHTMLService;
import com.brightslearning.webapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentHTMLService studentsHtmlService;
    private final StudentService studentService;
    private final SearchService searchService;

    @Autowired
    public StudentController(StudentRepository studentRepository,
                             StudentHTMLService studentsHtmlService,
                             StudentService studentService,
                             SearchService searchService) {
        this.studentRepository = studentRepository;
        this.studentsHtmlService = studentsHtmlService;
        this.studentService = studentService;
        this.searchService = searchService;
    }

    @GetMapping("/students")
    @ResponseBody
    public String displayAllStudents() {
        return studentsHtmlService.studentListAsHtml();
    }

    @PostMapping("/add")
    @ResponseBody
    public String addStudent(@RequestParam String name,
                             @RequestParam String lastName,
                             @RequestParam Integer age,
                             @RequestParam String email,
                             @RequestParam String occupation) {

        return studentsHtmlService.newStudentCreatedAsHtml(name, lastName, age, email, occupation) +
                studentsHtmlService.studentListAsHtml();
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateStudent(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam String lastName,
                                @RequestParam Integer age,
                                @RequestParam String email,
                                @RequestParam String occupation) {
        Student updatedStudent = studentService.updateStudent(id, name, lastName, age, email, occupation);
        return studentsHtmlService.studentHasBeenUpdatedAsHtml(updatedStudent) +
                studentsHtmlService.studentListAsHtml();
    }

    @GetMapping("/edit")
    @ResponseBody
    public String editStudent(@RequestParam String id) {
        return studentsHtmlService.studentEditFormHtml(id);
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return studentsHtmlService.studentHasBeenRemovedAsHtml(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public String searchByLastName(@RequestParam String lastName) {
        List<Student> students = searchService.findStudentByLastName(lastName);
        return studentsHtmlService.studentListAsHtml(students);
    }

    @GetMapping("/searchany")
    @ResponseBody
    public String search(@RequestParam String name, @RequestParam String lastName) {
        List<Student> students = studentRepository.findByNameAndLastName(name, lastName);
        return studentsHtmlService.studentListAsHtml(students);
    }


}
