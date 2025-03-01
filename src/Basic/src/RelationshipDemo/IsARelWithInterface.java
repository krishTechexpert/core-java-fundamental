package Basic.src.RelationshipDemo;

//When a class implements an interface, it forms an IS-A relationship with that interface.

interface Vehicle { // Interface
    void start();
}

class Car implements Vehicle { // Car IS-A Vehicle and also denote // Loose coupling
    public void start() {
        System.out.println("Car starts with a key.");
    }
}


public class IsARelWithInterface {
    public static void main(String[] args) {
        Vehicle v = new Car(); //// Can replace with Cat later
        v.start();
    }
}

//output
//Car starts with a key.
//Car implements Vehicle, meaning Car IS-A Vehicle.
//The Car class must override the start() method from Vehicle.


/*
✅ Benefit of loose coupling:

We can change Dog without affecting Animal.
If needed, we can replace Dog with Cat easily.
Less dependency compared to inheritance.

* */