package com.krish.FirstWebRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstWebRestApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstWebRestApiApplication.class, args);
		//after run check this on browser
		//http://localhost:8080/student/getAll work well return json
	}

}
