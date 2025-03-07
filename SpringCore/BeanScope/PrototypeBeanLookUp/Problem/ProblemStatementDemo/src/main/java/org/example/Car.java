package org.example;

public class Car {
    private Engine engine;

    // Constructor Injection
    public Car(Engine e){
        this.engine=e;
        System.out.println("Car instance created with Engine");
    }

    public void drive(){
        engine.start();
        System.out.println("Car is driving...");
    }
}
//✅ Car is a singleton bean, and it gets Engine via constructor injection.