package com.StudentAppdemo.studentApp;

import com.StudentAppdemo.studentApp.model.Address;
import com.StudentAppdemo.studentApp.model.Student;
import com.StudentAppdemo.studentApp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(StudentAppApplication.class, args);
	}

	private IStudentService studentService;

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Meerut","U.P");
		Student student=new Student("Krish","EE",address);
		studentService.addStudent(student);

		Student std2 = studentService.getById(2);

		//update department
		//std2.setDepartment("CS");

		// update address
		Address add = std2.getAddress();
		//set the city property
		add.setCity("rajouri");
		std2.setAddress(add);

		studentService.updateStudent(std2);
		System.out.println(std2);


		studentService.getAll().forEach(System.out::println);

		studentService.getByDepartment("EE").forEach(System.out::println);
		studentService.getByCity("delhi").forEach(System.out::println);


		/*
		* IMP Notes here
		*
		* First address data will store in address table then
		* student data will stored into student table
		*
		* Hibernate: insert into address (city,state,address_id) values (?,?,?)
		Hibernate: insert into student (address_address_id,department,studentname,student_id) values (?,?,?,?)

	*
	* spring.jpa.hibernate.ddl-auto=create
		it means every time when you run application then hibernate first drop table if already exists
		* then create new table
		*
		* Hibernate: alter table student drop foreign key FKnipsy8d8ys1hk9s4ehyk2t7wi
			Hibernate: drop table if exists address
			Hibernate: drop table if exists address_seq
			Hibernate: drop table if exists stud_seq
			Hibernate: drop table if exists student
			Hibernate: create table address (address_id integer not null, city varchar(255), state varchar(255), primary key (address_id)) engine=InnoDB
			Hibernate: create table address_seq (next_val bigint) engine=InnoDB
			Hibernate: create table stud_seq (next_val bigint) engine=InnoDB

	*
		 * */
	}
}
