package com.krish.FirstWebRestApi.Repo;

//3.) this class interact with Database (dto) but we have not connect with database
// so we used some dummy db opearation  which present in dto/student

import com.krish.FirstWebRestApi.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
* Spring Boot automatically detects StudentRepo as a Spring bean (if it is annotated with @Repository or @Component).
It then injects an instance of StudentRepo into StudentService at runtime.
* */

@Repository //it means bean bna sekty ho and manage also life cycle and inject bean into StudentService class
public class StudentRepo { // dependent class
    //this class interact with Database
    List<Student> studentList;

    public StudentRepo() {
        this.studentList = new ArrayList<>();

        Student s1=new Student(1,"Ayush","delhi","DSA");
        Student s2=new Student(2,"simran","pune","C++");
        Student s3=new Student(3,"piyush","calcutta","Java");
        Student s4=new Student(4,"neha","noida","phython");
        Student s5=new Student(5,"vikrant","meerut","html");

        this.studentList.add(s1);
        this.studentList.add(s2);
        this.studentList.add(s3);
        this.studentList.add(s4);
        this.studentList.add(s5);
    }


    public List<Student> getStudentList() {
        System.out.println("3.) repo running....");
        return studentList;
    }

    public void addStudent(Student s){
        studentList.add(s);
        System.out.println("new student added successfully");
    }

    public void deleteStudent(int id){
        for(Student std:studentList){
            if(std.getId() == id){
                studentList.remove(std);
                System.out.println("✅ student deleted successfully...");
                break;
            }
        }
    }

    /* chat gpt
        public boolean deleteStudent(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove(); // ✅ Safe way to remove from list
                System.out.println("✅ Student deleted successfully!");
                return true;
            }
        }
        return false; // ❌ Student not found
    }

    * */

    public void updateStudent(Student updatedStudent, int id){
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getId() == id) {
                studentList.set(i, updatedStudent);
                System.out.println("✅ Student updated successfully!");

            }
        }
    }

}

/*
* Spring finds @Repository and registers StudentRepo as a Spring Bean.
Then, Spring injects it into StudentService because of @Autowired.

* */