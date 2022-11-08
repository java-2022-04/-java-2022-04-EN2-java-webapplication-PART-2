package com.brightslearning.webapp.SpringDataAppDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private StudentRepository studentRepository;

    @Autowired
    public MyController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addsStudent(@RequestParam String name) {
        Student student = new Student();
        student.setId(1L);
        student.setName(name);
        studentRepository.save(student);
        return "saved";
    }
}
