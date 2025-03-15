package com.krish.JPAFirstDemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* JPA Notes

---------- Spring Data JPA-------
1.) Application contains several layers
		a.) Presentation Layer
		b.) Web Layer
				i.) controller layer
				ii.) Service layer
				iii.) Respository layer
		c.) Persistence layer
-----------------------------------

1.) Spring data JPA is used to develop Persistence layer in app
2.) provides ready made methods to perform CRUD operations
3.) JPA provide two interface
		a.) Crud Repository: perform normal crud operation
		b.) Jpa Respository: crud operation + pagination + sorting methods opeartion etc.
-----------------------------------

1.) For making connection to DB, we need driver and db config properties
		In application.properties we write db config such s username,password etc;

		we need driver so put in pom.xml file
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>

--------------------------

suppose you have made employee table in database

and we want to used this employee table in sprint boot then we only add to some JPA annotation
	4 IMP JPA notes:
	@Entity: class ko entity(table) banane k liye
	@table : class Emp(java code) hai but humko databse mai Employe1 table rekhna hai then used @Table
	@id	   : represent primary key in java code
	@Column: if java class and column in database table is different

*
* */

@SpringBootApplication
public class JpaFirstDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaFirstDemoAppApplication.class, args);
	}

}

/*
* Chat gpt notes
* Yes! In Spring Boot, when using JPA (Java Persistence API) with Hibernate,
*  we use specific annotations to map a Java class to a database table.
* Below is a proper explanation of the four important JPA annotations with an example.
*
* 1️⃣ @Entity (Convert Java Class into a Table)
It marks the Java class as a JPA entity (which means it will be mapped to a database table).
Hibernate automatically maps this class to a table.
* import jakarta.persistence.Entity;

@Entity  // Now, this class will be mapped to a database table
public class Employee {
}

-------------------------------------
2️⃣ @Table(name = "Employee1") (Map Class to Specific Table Name)
By default, the table name will be the same as the class name (Employee → employee in the database).
But if you want a different table name in the database (e.g., Employee1), use @Table(name = "Employee1").
* import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee1")  // Maps the class `Employee` to the `Employee1` table in the database
public class Employee {
}
---------------------------------------
*
* 3️⃣ @Id (Define Primary Key)
Every JPA entity must have a primary key.
The @Id annotation is used to mark a field as the Primary Key.
We can use @GeneratedValue for auto-increment.
import jakarta.persistence.*;

@Entity
@Table(name = "Employee1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;
}
-----------------------------------------
*
* 4️⃣ @Column(name = "emp_name") (Map Java Field to Specific Column Name)
If the Java field name is different from the database column name,
* we use @Column(name = "column_name").

* import jakarta.persistence.*;

@Entity
@Table(name = "Employee1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")  // Maps `fullName` Java field to `emp_name` column in DB
    private String fullName;

    @Column(name = "emp_salary")  // Maps `salary` field to `emp_salary` column in DB
    private double salary;

    // Constructors, Getters, and Setters
}
----------------------------------

 * */