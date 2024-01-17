package com.example.cruddemo;

import com.example.cruddemo.dao.IStudentDAO;
import com.example.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(IStudentDAO studentDAO){
		return runner ->{

			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void updateStudent(IStudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentId = 101;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(IStudentDAO studentDAO) {
		// get a list of students
		List<Student> response = studentDAO.findByLastName("Doe");

		// display a list of students
		for (Student student : response){
			System.out.println(student);
		}
	}

	private void queryForStudents(IStudentDAO studentDAO) {

		// get a list of students
		List<Student> response = studentDAO.findAll();

		// display a list of students
		for (Student student : response){
			System.out.println(student);
		}
	}

	private void readStudent(IStudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Daffy","Duck","daffy@duck.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student response =  studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + response);
	}

	private void createMultipleStudents(IStudentDAO studentDAO) {

		// create 3 student objects
		System.out.println("Creating 3 students object...");
		Student tempStudent1 = new Student("Paul","Doe","paul@doe.com");
		Student tempStudent2 = new Student("John","Smith","john@smith.com");
		Student tempStudent3 = new Student("Mary","Public","mary@public.com");

		// save the students objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display the saved student object
		System.out.println("Saved students are: "+ tempStudent1.toString() + "\n" + tempStudent2.toString() + "\n" + tempStudent3.toString());
	}

	private void createStudent(IStudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Jade","Doe","Jade@doe.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the saved student object
		System.out.println("Saved student is: " + tempStudent.toString());
	}
}
