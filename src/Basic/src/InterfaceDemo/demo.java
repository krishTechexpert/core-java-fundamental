package InterfaceDemo;

//Vehicle interface that defines common behaviors for different types of vehicles.

// by default , method are public and abstract inside interface;
// by defauly , varaible/member are public static final inside interface;
// class extends class
//class implements A,B,C
//interface extends interface A,Interface B
//sab vehicle k pass y start,stop,brake, etc funcationality hoti hai jo ki common hai..
//but different-2 vehicle apny hisaab sy funcationality add ker sekty hai
//to achieve 100% abstraction
//interface ka object nhi bnata hai
// interface support multiple inheritance so no ambiguity error
//It can be used to achieve loose coupling. [no dependency to other]

/*
Java Interface also represents the IS-A relationship.
It cannot be instantiated just like the abstract class.
Since Java 8, we can have default and static methods in an interface.
Since Java 9, we can have private methods in an interface

The Java compiler adds public and abstract keywords before the interface method.
Moreover, it adds public, static and final keywords before data members.

*/

interface Vehicle {
    //interface fields are implicitly public, static, and final.
    //This means that NoOfTyres will be a constant value that cannot be changed.
 String NoOfTyres = "4";// it will not work for bicycle b'coz tyres will be 2.
    // and we can not change constant value. so we used some method getNoOfTyres;
 void start();
 void stop();
 void accelerate(int speed);
 void brake();
 int getNoOfTyres(); // Method to get the number of tyres
}

 class Car implements Vehicle {
     private String model;

     public Car(String model){
         this.model= model;
     }
    public int getNoOfTyres(){
        return 4; // Car has 4 tyres
    }
    @Override
    public void start() {
        System.out.println(model + " is starting with " + getNoOfTyres() + " tyres.");
    }

    @Override
    public void stop() {
        System.out.println(model+ " is stopping..");
    }
    @Override
    public void accelerate(int speed){
        System.out.println(model + " is accelerating to " + speed + " km/h.");
    }
    public void brake() {
        System.out.println(model + " is braking.");
    }
}

// Implementing the Vehicle interface in the Bicycle class
 class Bicycle implements Vehicle {
    private String brand;
    public Bicycle(String brand) {
        this.brand = brand;
    }

    public int getNoOfTyres(){
        return 2;// Bicycle has 2 tyres
    }

    @Override
    public void start() {
        System.out.println(brand + " bicycle is ready to ride with " + getNoOfTyres() + " tyres.");
    }


    @Override
    public void stop() {
        System.out.println(brand + " bicycle is stopping.");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println(brand + " bicycle is accelerating to " + speed + " km/h.");
    }

    @Override
    public void brake() {
        System.out.println(brand + " bicycle is braking.");
    }
}

public class demo {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota");
        myCar.start();
        myCar.accelerate(60);
        myCar.brake();
        myCar.stop();

        System.out.println("----------------");

        Vehicle myBicycle = new Bicycle("Giant");
        myBicycle.start();
        myBicycle.accelerate(20);
        myBicycle.brake();
        myBicycle.stop();

    }

 }
