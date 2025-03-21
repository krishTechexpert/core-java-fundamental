package com.StudentAppdemo.studentApp.repository;

import com.StudentAppdemo.studentApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
    // findBy,  readBy,  getBy

    //department is the varaible defined in student table.
    // then make it First Letter Capital such as Department

    List<Student> findByDepartment(String department);

    //find the student list which belongs to particular department and
    // return list of Students


    List<Student> findByAddressCity(String city);
    //address is the instance varaible defined in student class
    // city is the instance varaible defined in Address class

    //so make it first letter capital for both and combined it
    //List<Student> findByAddressCity(String city); it is ready now

}
