package com.brightslearning.webapp;

import com.brightslearning.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataAppDemoApplication {

	@Autowired
	public StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAppDemoApplication.class, args);
	}

}
