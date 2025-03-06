package org.example;

/*
* Let's integrate Prototype scoped beans with Dependency Injection in Spring without
* annotations using XML configuration.

  🔹 Scenario:
        We will have two classes:

        1.) StudentService (Singleton Bean) – Manages Student objects.
        2.) Student (Prototype Bean) – Represents individual student objects.
        3.) StudentFactory: Always returns a new  student instance
* Each time StudentService requests a Student object, a new instance should be injected.

*
* 🔹 Factory Method Injection for Prototype Beans in Spring (Without Annotations)

 * */

//📝 Step 1: Create the Prototype Bean (Student.java)


public class Student {
    private String name;
    public Student() {
        System.out.println("Student instance created");
    }
 //Constructor prints a message when a new Student instance is created.

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Student Name: " + name);
    }

}
