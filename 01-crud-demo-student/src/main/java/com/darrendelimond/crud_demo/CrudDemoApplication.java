package com.darrendelimond.crud_demo;

import com.darrendelimond.crud_demo.dao.StudentDAO;
import com.darrendelimond.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){


		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student student = new Student("Gabriel", "Delimond", "gabe-delimond@gmail.com");

		studentDAO.save(student);
		System.out.println("Saving Student to Database ...");

		System.out.println("Saved student Generated id  "+ student.getId());


	}
}


