package com.octocat.springboot.cruddemo.dao;

import com.octocat.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
