package org.example;

public class Car {
    private Engine engine;

    public Car(){
        System.out.println("car default constructor...");
    }

    public void setEngine(Engine e){
        System.out.println("Car  setter method...");
        this.engine =e;
    }

    public void drive(){
        int start = engine.start();
        if(start>=1) {
            System.out.println("Car Running...");
        }
        else {
            System.out.println("Engine not started!");
        }
    }

}
