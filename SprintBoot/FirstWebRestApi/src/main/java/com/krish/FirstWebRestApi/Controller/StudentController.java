package com.krish.FirstWebRestApi.Controller;

import com.krish.FirstWebRestApi.Service.StudentService;
import com.krish.FirstWebRestApi.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Controller: return jsp or html(views) page when we work for MVC
    such as html page return kerta hai, In MVC spring framework, we put html page inside views directory
    "home-page"---> webApp--->Web-INF---views ---> home-page.html
  ---------------------
 */
//@RestController return json mainly used for making api

@RestController
@RequestMapping("/student") // resource [protocol/domain/resourse/resource-Id like http://krish.com/student/getAll
                            // when we make any crud request then it will first hit  resource(@RequestMapping("/student"))
//1.) this StudentController (Student.java) class interact with Student service (StudentService.java)
public class StudentController {

    @Autowired
    private StudentService service;//Field DI

//    public StudentController(){
//        System.out.println("1.) controller running...");
//    }
//
        @Autowired
//    public StudentController(StudentService service) { constructor  DI
//        this.service = service;
//    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        System.out.println("1.) controller running...");
        return service.getAllStudent();
    }
    @PostMapping("/create")
    public void createStudent(@RequestBody Student std) {
        service.createStudent(std);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id){
        service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student std,@PathVariable int id){
        System.out.println(std);
        System.out.println(id);
        service.updateStudent(std,id);
    }
}
