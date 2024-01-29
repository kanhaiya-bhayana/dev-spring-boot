package com.octocat.springboot.thymeleafdemo.controller;

import com.octocat.springboot.thymeleafdemo.entity.Employee;
import com.octocat.springboot.thymeleafdemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService service){
        employeeService = service;
    }

    // add mapping for listing the employees
    @GetMapping("/list")
    public String listEmployee(Model theModel){

        // get the employee from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees",theEmployees);

        return "list-employees";
    }
}
