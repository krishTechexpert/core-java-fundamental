package org.example;

//4️⃣ Load Spring Context and Test

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap =new ClassPathXmlApplicationContext("spring-config.xml");// it will create object for both Engine and Car, you can run and check

//        Car car = ap.getBean(Car.class);
//        car.drive(); // same way below

        Car car1 = (Car) ap.getBean("carBean");
        car1.drive(); // First call

        System.out.println("----");

        Car car2 = (Car) ap.getBean("carBean");
        car2.drive(); // Second call

    }
}

//🚨 Issue: The same Engine instance is used for both cars!
//Even though engineBean is a prototype,
// it was only created once at the time of Car's creation.


/*🔹 What is the Problem?

Issue:	The same Engine instance is used every time.
Why It Happens? : 	Car is a singleton, so it gets only one instance of Engine at creation time. evenif you called Car meny times but only one instance will create. due to singleton nature
------------------------------------------------
Issue: Prototype scope is ignored after injection.
Why It Happens? : Constructor injection happens only once when the Car bean is created.
------------------------------------------------
Issue: Every time drive() is called, it uses the same Engine.
Why It Happens? : Prototype beans need to be fetched dynamically, but constructor injection does not support this.

*/

//✅ Solution: Lookup Method Injection /Factory Method injection


//Output
/*
* A new Engine instance is created!
Car instance created with Engine
Engine is starting...
Car is driving...
----
Engine is starting...
Car is driving...

* */