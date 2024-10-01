package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.dao.StudentDAO;
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

	//commandLineRunner Executes after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			createStudent(studentDAO);

//			findStudent(studentDAO);
//			findStudentsListByLastName(studentDAO);
//			findAllStudents(studentDAO);

			//Update the entry lastName in the student table in db, finding by id
//			updateLastNameById(studentDAO);

			// Update all the records lastName of the Student
//			updateAll(studentDAO, "Gupta");

			// delete record by the id
//			deleteById(studentDAO, 1);

			// Delete All records based on LastName
//			deleteByLastName(studentDAO, "Gupta");
		};
	}

	private void deleteByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("The list before Deletion");
		findAllStudents(studentDAO);
		studentDAO.deleteAllByLastName(lastName);
		System.out.println("After Deletion");
		findAllStudents(studentDAO);
	}

	private void deleteById(StudentDAO studentDAO, int id) {
		System.out.println("Deleting the Student: " + id);
		studentDAO.deleteById(id);
		findAllStudents(studentDAO);
	}

	private void updateAll(StudentDAO studentDAO, String lastName) {
		int numberOfRecordsUpdated =  studentDAO.updateAllLastName(lastName);
		System.out.println("Number of records updated: " + numberOfRecordsUpdated);
		findAllStudents(studentDAO);
	}

	private void updateLastNameById(StudentDAO studentDAO) {
		System.out.println("Updating the Student record for the id 1");
		studentDAO.updateLastNameById(1, "Gupta");
		findAllStudents(studentDAO);
	}


	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object");
		Student tempStudent1 = new Student("Aadhar", "Bansal", "aadharbansal@outlook.com");
		Student tempStudent2 = new Student("Ishan", "Gupta", "ishangupta@outlook.com");
		Student tempStudent3 = new Student("Moksha", "Gupta", "mokshagupta@outlook.com");

		//save the student object
		System.out.println("saving the Student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


		//display the id of saved student
		System.out.println("Saved Student. Generated id: " + tempStudent1.getId() + " " + tempStudent2.getId() + " " + tempStudent3.getId());
	}

	private void findStudent(StudentDAO studentDAO, int... i){

		System.out.println("The Student for the id " + i[0]);
		System.out.println(studentDAO.findById(i[0]));
	}

	private void findStudentsListByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("Gupta");
		System.out.println("The List of the Students with the LastName: Gupta");
		students.forEach(System.out::println);
	}

	private void findAllStudents(StudentDAO studentDAO) {
		System.out.println("List of all the Students");
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
	}



}
