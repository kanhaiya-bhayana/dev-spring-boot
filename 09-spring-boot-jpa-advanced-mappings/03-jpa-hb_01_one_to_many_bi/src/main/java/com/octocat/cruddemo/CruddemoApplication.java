package com.octocat.cruddemo;

import com.octocat.cruddemo.dao.AppDAO;
import com.octocat.cruddemo.entity.Course;
import com.octocat.cruddemo.entity.Instructor;
import com.octocat.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			 // createInstructor(appDAO);
			// findInstructorById(appDAO);
			// deleteInstructorById(appDAO);
			// findInstructorDetailById(appDAO);
			// deleteInstructorDetailById(appDAO);
			// createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			findCoursesForInstructor(appDAO);
		};
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+ theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "mary", "susan@mary.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Coding"
				);

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Java - The Ultimate Guide");
		Course tempCourse2 = new Course("Spring-boot - Complete Bootcamp");

		// add courses to the instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will also save the courses
		// because the CascadeType.Persist
		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("The course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId = 3 ;
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetailById(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		if (tempInstructorDetail == null){
			System.out.println("Not found");
			return;
		}

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor response = appDAO.findInstructorById(1);

		if (response != null){
			System.out.println(response.toString());
		}
		else System.out.println("Not found");
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "chad@darby.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Code code code"
				);
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@patel.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Singing"
				);

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving Instructor: "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");


	}

}
