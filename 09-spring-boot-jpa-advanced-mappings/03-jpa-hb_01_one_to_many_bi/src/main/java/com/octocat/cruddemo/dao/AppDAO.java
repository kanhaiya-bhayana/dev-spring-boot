package com.octocat.cruddemo.dao;

import com.octocat.cruddemo.entity.Course;
import com.octocat.cruddemo.entity.Instructor;
import com.octocat.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
}
