package org.example;

/*
* 🔥 Problem: Singleton Beans Cannot Inject Prototype Beans Correctly

* Let's first demonstrate the problem that occurs when a singleton bean (Car) tries
* to inject a prototype bean (Engine) using constructor injection.

    🔹 Problem Explanation
1.) Singleton Beans: Object Created once and shared across the application.
2.) Prototype Beans: A new instance is created every time it is requested/called.

* Issue: When a singleton bean injects a prototype bean via constructor/setter injection,
*  it gets only one instance of the prototype bean (but we need new instance everytime we called it), instead of a fresh instance each time.

 *  ----- Solutions (2 ways )-------* *
 * 1.) Lookup method: Today we will learn this in solution folder, here we are trying to understand the problem only
 * 2.)  Factory Method Injection for Prototype Beans in Spring (Without Annotations)
 *          a.) WE already Covered this so please check BeanScope/PrototypeBeanScope in githuh
 * */

//📝 Example: Singleton Bean Injecting Prototype Bean (Incorrect Behavior)

public class Engine {
    public Engine(){
        System.out.println("A new Engine instance is created!");
    }
    public void start(){
        System.out.println("Engine is starting...");
    }
}
// ✅ This is a prototype bean, so a new instance should be created each time.


//es engine ko jab hum call kre toh each time new engine object bn jana chiye but esa hoga nhi..
//yhi toh problem statement create ker rehy hai hum