package com.darrendelimond.crud_demo;

import com.darrendelimond.crud_demo.dao.StudentDAO;
import com.darrendelimond.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){


		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO, 1);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
			deleteStudent(studentDAO);

		};
	}




	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student objects ...");
		Student student1 = new Student("Gabriel", "Delimond", "gabe-delimond@gmail.com");
		Student student2 = new Student("Darren", "Delimond", "darren-delimond@gmail.com");
		Student student3 = new Student("Brenda", "Kayira", "brenda-kayira@gmail.com");
		Student student4 = new Student("Jean", "Delimond", "jean-delimond@gmail.com");
		Student student5 = new Student("Annet", "Kayira", "annet-kayira@gmail.com");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
		studentDAO.save(student5);

		System.out.println("Saving Students to Database ...");

		System.out.println("Saved student Generated id  "+ student1.getId());
	}

	public Student readStudent(StudentDAO studentDAO, int id){

		System.out.println("Finding Student with the id of : "+ id);

		Student returnedStudent = studentDAO.findById(id);

		System.out.println("Retuned Student is : " + returnedStudent.toString());

		return returnedStudent;
	}


	private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();

		System.out.println("Retrieving all Students ... ");

		for(Student student:theStudents){
			System.out.println(student.toString());
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findByLastName("Kayira");

		System.out.println("Retrieving all Students with  provided last name... ");

		for(Student student:theStudents){
			System.out.println(student.toString());
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		System.out.println("Retrieving specified user ...");
		Student querystudent = studentDAO.findById(1);

		querystudent.setFirstName("Gabriel");

		System.out.println("Updating First Name");
		studentDAO.update(querystudent);

		System.out.println("Updated Student : " + querystudent);
	}


	private void deleteStudent(StudentDAO studentDAO){
		System.out.println("Finding Student to delete");
		int id = 2;

		System.out.println("Deleting the student");
		studentDAO.delete(id);

		System.out.println("Deletion completed");
	}
}


