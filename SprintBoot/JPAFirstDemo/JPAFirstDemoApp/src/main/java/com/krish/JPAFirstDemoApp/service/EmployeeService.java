package com.krish.JPAFirstDemoApp.service;

import com.krish.JPAFirstDemoApp.entity.Employee;
import com.krish.JPAFirstDemoApp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo; // y toh interface hai phir eska object kesa bnega as we already learned interface ka object nhi bnata hai
    // jpa run time per EmployeeRepo class ki implmentation provide kraye and object create ker dega and insert into here private EmployeeRepo employeeRepo;


    public List<Employee> getAllEmp(){
       List<Employee> list=employeeRepo.findAll();
        System.out.println(list); //[Employee(id=1, name=krish, salary=10000.0, dep=HR)]
        // lombok automatically generated toString(),getter,setter etc  as we already mentioned insdie entity--->Employee class please check that
        return list;
    }

    public Employee createEmp(Employee e){
        Employee newEmp =employeeRepo.save(e);
        return newEmp;
    }

    public void deleteEmp(int id) {
        employeeRepo.deleteById(id);
        System.out.println("deleted successfully");
    }

    public void updateEmp(Employee emp, int id) {
        /*
        *
        * 🌟 Problem Without Optional
            If you use employeeRepo.getById(id), and the id does not exist,
            * it throws an exception (EntityNotFoundException), which can crash your application.
            🌟  Solution:
            * I used Optional<Employee> in updateEmp() to handle cases where the employee
            * with the given ID does not exist in a clean and safe way.
        * */

        Optional<Employee> existingEmp = employeeRepo.findById(id); // no need try catch u can used Optional

        if(existingEmp.isPresent()){
            Employee updatedEmp = existingEmp.get();  // Retrieve the employee
            updatedEmp.setName(emp.getName());
            updatedEmp.setSalary(emp.getSalary());
            updatedEmp.setDep(emp.getDep());
            employeeRepo.save(updatedEmp);
            System.out.println("Employee updated successfully: " + updatedEmp);

            /*
            * another good approach in which no need to write multiple setter
            *
            * Employee updatedEmp = existingEmp.get();  // Retrieve existing employee
             BeanUtils.copyProperties(emp, updatedEmp, "id");  // Copy all fields except ID
                employeeRepo.save(updatedEmp);  // Save updated employee
            System.out.println("Employee updated successfully: " + updatedEmp);

            * */

        }else {
           System.out.println("Emp not found with="+id);
       }
    }
}
