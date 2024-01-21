package com.octocat.springboot.cruddemo.rest;

import com.octocat.springboot.cruddemo.dao.IEmployeeDAO;
import com.octocat.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private IEmployeeDAO employeeService;

    // quick and dirty: inject employee dao (use constructor injection)
//    @Autowired
    public EmployeeRestController(IEmployeeDAO service){
        employeeService = service;
    }

    // expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
