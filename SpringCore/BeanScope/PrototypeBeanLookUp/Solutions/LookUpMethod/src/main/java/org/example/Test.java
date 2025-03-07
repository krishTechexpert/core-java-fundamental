package org.example;

//4️⃣ Load Spring Context and Test Again (Main.java)

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Car car1 = (Car) context.getBean("carBean");
        car1.drive(); // First call
        //🚀 Now, every time drive() is called, a new Engine instance is created!
        System.out.println("----");

        Car car2 = (Car) context.getBean("carBean");
        car2.drive(); // Second call

        //With Lookup Method Injection → A new Engine instance is provided every time drive() is called.

    }
}

//Output
/*
* A new Engine instance is created!
Car is driving...
Engine is starting...
----
A new Engine instance is created!
Car is driving...
Engine is starting...

* */


/*
* Spring now calls getEngine() dynamically to fetch a new Engine instance each time.
Lookup method injection ensures that a new prototype bean is returned whenever needed.
Spring overrides getEngine() dynamically to always return a fresh instance.

*
🎯 Final Thoughts
Without Lookup Method Injection → The singleton Car always gets the same Engine instance.
With Lookup Method Injection → A new Engine instance is provided every time drive() is called.
*
 * */