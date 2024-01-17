package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import java.util.List;

public interface IStudentDAO {
    void save(Student theStudent);
    Student findById(Integer Id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);
}
