package com.octocat.springboot.cruddemo.rest;

import com.octocat.springboot.cruddemo.entity.Employee;
import com.octocat.springboot.cruddemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private IEmployeeService employeeService;

    // quick and dirty: inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController(IEmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee not found - "+employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON -- set it to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.findById(theEmployee.getId());

        if (dbEmployee == null) {
            throw new RuntimeException("Employee does not exist - " + theEmployee.getId());
        }
        Employee updatedEmployee = employeeService.save(theEmployee);
        return updatedEmployee;
    }

    // add mapping for DELETE /employee/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }






}
