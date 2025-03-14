package com.krish.FirstWebRestApi.Service;

import com.krish.FirstWebRestApi.Repo.StudentRepo;
import com.krish.FirstWebRestApi.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//2.) this class interact with Repo

@Service
public class StudentService { //target class

    @Autowired
    private  StudentRepo studentRepo; //dependent object

//    public StudentService(){
//        System.out.println("2.) Service running...");
//
//    }
//
//    @Autowired  // Spring injects an instance of StudentRepo automatically
//    public StudentService(StudentRepo studentRepo) { // Constructor Injection
//        this.studentRepo = studentRepo;
//    }

    public List<Student> getAllStudent(){
            //with core java
       // StudentRepo sr=new StudentRepo();//tightly coupled
        //return sr.getStudentList();
        //if we used spring framework then we used to do some xml confguration to make bean

        //but here we used sring boot so it will inject DI automatically with no configuration
        //we used @Autowired

        /*
        * @Autowired is a Spring annotation used for Dependency Injection (DI).
        *  It tells Spring to automatically inject an instance of a required dependency into a class.

         * */
        System.out.println("2.) Service running...");
        List<Student> allStudents =  studentRepo.getStudentList();
        return allStudents;
    }

    public void createStudent(Student s){
        studentRepo.addStudent(s);
    }

    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    public void updateStudent(Student s,int id){
        studentRepo.updateStudent(s,id);
    }


}

/*
* With @Autowired in Spring Boot:

@Autowired automatically injects StudentRepo into StudentService without manual object creation.
This is part of Dependency Injection (DI), which makes the code more flexible and loosely coupled.

* */


/*
* 🔹 How @Autowired Works in Spring Boot
Spring Boot automatically detects StudentRepo as a Spring bean (if it is annotated with @Repository or @Component).
It then injects an instance of StudentRepo into StudentService at runtime.


* */