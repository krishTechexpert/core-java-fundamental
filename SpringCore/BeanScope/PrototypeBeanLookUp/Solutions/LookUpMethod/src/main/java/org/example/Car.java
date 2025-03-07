package org.example;

public abstract class Car {
    public void drive(){
        Engine engine = getEngine(); // Lookup method to get a new Engine instance
        System.out.println("Car is driving...");
        engine.start();
    }
    // Lookup Method (Spring will override this method dynamically)
    protected abstract Engine getEngine();

}

/*
* ✅ Car is now an abstract class and has an abstract method getEngine().
✅ Spring will override this method dynamically and provide a new instance of Engine
* each time it is called.


* */
