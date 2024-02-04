package com.octocat.cruddemo.dao;

import com.octocat.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager

    // inject entity manger using constructor injection
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager theEntityManger){
        this.entityManager = theEntityManger;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        if (tempInstructor == null) {
            System.out.println("Instructor not exist");
            return;
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
        System.out.println("Deleted");
    }
}
