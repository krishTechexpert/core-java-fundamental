package com.krish.JPAFirstDemoApp.controller;

import com.krish.JPAFirstDemoApp.entity.Employee;
import com.krish.JPAFirstDemoApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") // all crud http request first this resource /employee
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmp(){
        return empService.getAllEmp();
    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee emp){
        return empService.createEmp(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable int id){
        System.out.println(id);
        empService.deleteEmp(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee emp,@PathVariable int id){

         empService.updateEmp(emp,id);
    }

}
