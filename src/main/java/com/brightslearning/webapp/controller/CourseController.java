package com.brightslearning.webapp.controller;

import com.brightslearning.webapp.service.CourseHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {

    @Autowired
    private CourseHtmlService courseHtmlService;

    @GetMapping("/course")
    @ResponseBody
    public String displayAllCourses() {
        return courseHtmlService.displayAllCourses();
    }
}
