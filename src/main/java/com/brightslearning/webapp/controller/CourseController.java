package com.brightslearning.webapp.controller;

import com.brightslearning.webapp.service.CourseHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
public class CourseController {

    @Autowired
    private CourseHtmlService courseHtmlService;

    @GetMapping("/courses")
    @ResponseBody
    public String displayAllCourses() {
        return courseHtmlService.displayAllCourses();
    }
    @GetMapping("/course")
    @ResponseBody
    public String displayCourseByName(@RequestParam String name) {
        return courseHtmlService.displayCourse(name);
    }

    @GetMapping("/course/add")
    @ResponseBody
    public String addCourse() {
        return courseHtmlService.newCourseHtml();
    }




}
