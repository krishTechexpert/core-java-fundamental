package org.example;

public class Car {
    private Engine engine; //dependency

     //Setter method for injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // constructor will not work for autowire="byName | byType" you will need autowire="constructor"
//    public Car(Engine engine) {
//        this.engine = engine;
//    }

    public void drive() {
        System.out.println("Car is driving...");
        engine.start();
    }

}
//✅ The Car class depends on Engine, and we use a setter method to inject the dependency.
