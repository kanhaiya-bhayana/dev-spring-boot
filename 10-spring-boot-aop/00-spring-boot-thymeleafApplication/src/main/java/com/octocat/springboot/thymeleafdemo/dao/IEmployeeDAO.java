package com.octocat.springboot.thymeleafdemo.dao;

import com.octocat.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
