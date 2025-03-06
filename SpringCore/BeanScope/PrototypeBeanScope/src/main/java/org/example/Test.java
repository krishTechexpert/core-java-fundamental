package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("Beans.xml");

        StudentService s = ap.getBean(StudentService.class);
        s.displayStudent("krish");
        s.displayStudent("pooja");
        s.displayStudent("ravi");
    }
}

/*
* 🎯 Key Takeaways
1.) Prototype beans create a new instance every time they are requested.
2.) Singleton beans can depend on prototype beans using a Factory Class.
3.) Factory Method Injection ensures proper prototype instance management.
4.) More flexible than lookup methods and works without modifying the singleton bean.

*
* */