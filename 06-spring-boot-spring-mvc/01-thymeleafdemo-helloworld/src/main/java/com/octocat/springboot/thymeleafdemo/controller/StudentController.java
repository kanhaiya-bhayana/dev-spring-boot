package com.octocat.springboot.thymeleafdemo.controller;

import com.octocat.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> programmingLanguages;

    @Value("${operatingSystems}")
    private List<String> operatingSystem;



    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of programming languages to the model
        theModel.addAttribute("favoriteLanguage", programmingLanguages);

        // add the list of operatingSystem to the model
        theModel.addAttribute("operatingSystem",operatingSystem);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
        System.out.println("theStudent: "+ theStudent.toString());
        return "student-confirmation";
    }
}
