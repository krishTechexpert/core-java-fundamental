package com.StudentAppdemo.studentApp.service;

import com.StudentAppdemo.studentApp.model.Student;
import com.StudentAppdemo.studentApp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    private IStudentRepository studentRepository;

    //setter dependency injection
    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
      Optional<Student> student= studentRepository.findById(studentId);
      if(student.isPresent()){
        Student std = student.get();
        return std;
      }
        else {
            System.out.println("Student not found with="+studentId);
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByDepartment(String department) {
        // we need to write for custom jpa sql query to find getByDepartment
        return studentRepository.findByDepartment(department);
    }

    @Override
    public List<Student> getByCity(String city) {
        return studentRepository.findByAddressCity(city);
    }
}
// all these method are called from main class(StudentAppApplication) using CommandLineRunner
// we are not using rest api here
