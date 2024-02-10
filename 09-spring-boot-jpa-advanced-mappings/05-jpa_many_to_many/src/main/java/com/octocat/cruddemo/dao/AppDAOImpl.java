package com.octocat.cruddemo.dao;

import com.octocat.cruddemo.entity.Course;
import com.octocat.cruddemo.entity.Instructor;
import com.octocat.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        // break the association of all the courses for the instructor
        for (Course c : courses){
            c.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
        System.out.println("Deleted");
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve the instructor
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        if (tempInstructorDetail == null) {
            System.out.println("InstructorDetail not exist");
            return;
        }

        // remove the associated reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        // delete the instructorDetail
        entityManager.remove(tempInstructorDetail);
        System.out.println("Deleted");
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class
        );
        query.setParameter("data", theId);

        // execute the query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                + "where i.id = :data", Instructor.class
        );
        query.setParameter("data", theId);

        // execute the query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {

        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {

        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        // retrieve the course
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {

        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class);

        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;
    }


}
