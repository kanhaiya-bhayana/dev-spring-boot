package com.octocat.springboot.cruddemo.service;

import com.octocat.springboot.cruddemo.dao.IEmployeeDAO;
import com.octocat.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(IEmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
