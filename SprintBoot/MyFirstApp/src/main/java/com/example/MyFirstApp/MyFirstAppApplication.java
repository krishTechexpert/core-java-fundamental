package com.example.MyFirstApp;

// sprint boot = DI + Auto configuration + Embedded server(tomcat) + Actuator(production-ready monitoring and management endpoints)

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyFirstAppApplication.class, args);//internally y bi ApplicationContext ko used kerta hai
	}

}

/* when we run this file then intelij sirf .class file use kerta hai, build nhi bnaata hai
* so we need to make build with help of maven.
* intelij internally tomcat ko .class file provide kra deta hai, it means tomcat automatically .class file uta leta hai
*
* if suppose we need to manually deploy these file on server then we will deploy .jar file (MyFirstApp-0.0.1-SNAPSHOT.jar)
* */

/*Note:
* when u run this file, may be it will not run as there is no jar file MyFirstApp.jar
* /* first check MyFirstApp-0.0.1-SNAPSHOT.jar file is present inside target folder,
if no then need to make it for this goto maven icon on right side
	then click myFirstApp, lifecycle, click on install which will produce .jar file
 */

/*
* Note: Based on type of our application, it will start IOC container
* 1.) Run() method will print banner on console inside IntellJ
* 2.) Run() method will start IOC container
* 3)  Run() method will return context of IOC container
*
* */


/*
* Imp interview question
*  @SpringBootApplication: it is combination of 3 Annotation
*
* 	i.) @SpringBootConfiguration: it will tell spring  that this is configuration class hai jismy bea ho sekty hai
* 	Tells Spring that this class is a configuration class.
	Equivalent to @Configuration.
	*
	* Spring Boot supports different types of configurations:
		1️⃣ Java-Based Configuration (Recommended)
		Uses @Configuration or @SpringBootConfiguration.
		Defines beans inside Java classes instead of XML.
--------------------------------------------------------
*
* 	ii.) EnableAutoConfiguration: it will handle/add automatically all configuration such as DB config
* add JPA dependency in POM.xml file
* <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
and run you will see error
* Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
these error are detected by EnableAutoConfiguration
*
* now  add mysql connector.jar dependency in POM.xml file and BOOM
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.30</version>
		</dependency>
--------------------------------
* so we will write only below DB config in Application.properties, no need to write jdbc code
*  then EnableAutoConfiguration will handle config for us for making DB connection
* spring.datasource.url=jdbc:mysql://localhost:3306/myDB
* spring.datasource.userbame=root
* spring.datasource.password=root
* spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
* WOW...
* open and check for DataSourceProperties.java files runtime per y class load hogi for DB
*
* username and password etc will be added in this class DataSourceProperties.java on runtime
*
* ------------------------------------------------------------------
*
* 	iii.) @ComponentScan: sary bean (such as @Service,@RestController,@respository  ko bean bna dega etc.) ko scan kerna and IOC per register kerna @componentScan ka kkaam hai
*
* @ComponentScan is an annotation in Spring that scans and registers beans (components) into the Spring IoC (Inversion of Control) container.

	* 1️⃣ What Does @ComponentScan Do?
When you use @ComponentScan, it:
✅ Scans packages for Spring-managed components like @Component, @Service, @Repository, and @Controller.
✅ Registers them as beans in the Spring Application Context (IoC container).
✅ Enables Dependency Injection so beans can be autowired.

By default, @SpringBootApplication already includes @ComponentScan, so you don’t need to add it manually unless you want to scan additional packages.

4️⃣ What @ComponentScan Registers?
It detects and registers:

@Component – Generic component
@Service – Business logic component
@Repository – DAO (Database Access Object)
@Controller / @RestController – Web controllers

*
/*@Controller: return jsp or html(views) page when we work for MVC
    such as html page return kerta hai, In MVC spring framework, we put html page inside views directory
    "home-page"---> webApp--->Web-INF---views ---> home-page.html
  ---------------------
 */
//@RestController return json mainly used for making api

* */



/*
* Key Takeaways
✅ No need for boilerplate JDBC code—just add dependencies and properties!
✅ Spring Boot Auto-Configuration detects and applies settings automatically.
✅ Component Scanning registers beans automatically in IoC.


* */