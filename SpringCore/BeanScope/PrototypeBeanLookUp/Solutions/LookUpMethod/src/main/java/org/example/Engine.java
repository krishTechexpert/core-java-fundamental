package org.example;

/*
* ✅ Solution: Using Lookup Method Injection
To fix the problem, which already seen in PrototypeBeanLookUp/problem folder
* we will use lookup method injection,
* which ensures that every time a singleton bean (Car) needs a prototype bean (Engine),
*  a new instance of Engine is created dynamically.


* */

public class Engine {
    public Engine(){
        System.out.println("New engine instance created...");
    }
    public void start(){
        System.out.println("engine is started...");
    }
}
