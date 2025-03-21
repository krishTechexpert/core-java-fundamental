package com.StudentAppdemo.studentApp.service;

import com.StudentAppdemo.studentApp.model.Student;

import java.util.List;

public interface IStudentService {

    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);

    Student getById(int studentId);
    List<Student> getAll();
    List<Student> getByDepartment(String department);
    List<Student> getByCity(String city);

}
