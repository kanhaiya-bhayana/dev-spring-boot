package com.octocat.springboot.cruddemo.service;

import com.octocat.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
