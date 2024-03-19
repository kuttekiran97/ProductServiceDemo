package com.productservice.productservice;



import com.productservice.productservice.inheritanceRelations.singleTable.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
 	private ST_MentorRepository ST_mentorRepository;
	 private ST_UserRepository ST_userRepository;
	 private ST_StudentRepository ST_studentRepository;

	 ProductServiceApplication(ST_MentorRepository tbc_mentorRepository,ST_UserRepository tbc_userRepository,ST_StudentRepository tbc_studentRepository){
		 this.ST_mentorRepository=tbc_mentorRepository;
		 this.ST_studentRepository=tbc_studentRepository;
		 this.ST_userRepository=tbc_userRepository;
	 }
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Mentor mentor=new Mentor();
		mentor.setAvgRating(4.9);
		mentor.setName("Kiran");
		mentor.setEmailId("abc@gmail.com");
		ST_mentorRepository.save(mentor);

		Student student = new Student();
		student.setPsp(90);
		student.setName("John");
		student.setEmailId("xyz.com");
		ST_studentRepository.save(student);

		User user = new User();
		user.setName("John");
		user.setEmailId("xyz.com");
		ST_userRepository.save(user);
	List<User> users= ST_userRepository.findAll();

		for (User user1: users){
			System.out.println(user1.toString());
		}

	}
}
