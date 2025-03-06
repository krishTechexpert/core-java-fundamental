package org.example;

/*
* 🔹 Factory Method Injection for Prototype Beans in Spring (Without Annotations)
Instead of using a lookup method,
*
*     <!-- Singleton Bean using lookup method -->
    <bean id="studentService" class="StudentService">
        <lookup-method name="getStudent" bean="studentBean"/>
    </bean>

* Good Approach below
* we can use Factory Method Injection to inject a new instance of a prototype bean
* into a singleton bean.

* 🔥 Key Concept:
The singleton bean (StudentService) cannot directly inject a prototype bean (Student),
* since Spring creates the singleton bean only once.
Instead, we define a Factory Class (StudentFactory) that Spring calls
* whenever a new Student instance is needed.

*
* */


//📝 Step 2: Create a Factory Class (StudentFactory.java)
public class StudentFactory {

    public Student createStudent(){
        return new Student(); // Always returns a new instance
    }
}

//✅ createStudent() ensures a new Student instance is returned every time.