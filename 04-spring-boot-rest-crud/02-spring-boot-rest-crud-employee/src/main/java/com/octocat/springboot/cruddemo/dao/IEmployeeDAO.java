package com.octocat.springboot.cruddemo.dao;

import com.octocat.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
}
