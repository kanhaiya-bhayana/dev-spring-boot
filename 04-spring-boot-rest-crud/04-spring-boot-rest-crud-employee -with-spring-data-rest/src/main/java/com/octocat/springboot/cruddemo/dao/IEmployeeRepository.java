package com.octocat.springboot.cruddemo.dao;

import com.octocat.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
}
