package org.example;


//📝 Step 3: Create the Singleton Bean (StudentService.java)

public class StudentService {
    private StudentFactory studentFactory;

    // Constructor-based injection
    public StudentService(StudentFactory studentFactory) {
        this.studentFactory = studentFactory;
        System.out.println("StudentFactory initated");
    }

    public void displayStudent(String name) {
        Student student = studentFactory.createStudent(); // Get a new instance
        student.setName(name);
        student.show();
    }

}
//✅ StudentService is a singleton but always gets a fresh Student instance from the StudentFactory.