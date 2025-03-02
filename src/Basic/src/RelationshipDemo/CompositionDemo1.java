package Basic.src.RelationshipDemo;

/*
* What is Composition?
Composition is a strong HAS-A relationship where one class contains another class,
* and the contained class cannot exist independently without the container.

* Understanding Contained Object and Container Class in Composition
Let's break it down simply:

🔹 Container Class → The main class that "contains" another class as part of its definition.
🔹 Contained Object → The object inside the container class that it depends on.


*In other words, Composition is a restricted form of Aggregration in which two entities are
* highly dependent on each other. and it represent part-of relationship.
* when there is a composition between two entities, the composed object can not exist without the other entity.
*If we say every student k pass address hona zaruri hai then it is strict(tightly) Aggreagration known as Association
*
* In project, It depends on client requirement, he want Aggragration or Association in project requirement
*
🔹 Key Characteristics of Composition:

Strong Association – The contained object depends on the container.
Tightly Coupled – If the container is destroyed, the contained object is also destroyed.
Used for Encapsulation – Helps in hiding complexity and improving code organization.
More Flexible than Inheritance – Instead of extending a class (IS-A), you can include it (HAS-A), reducing tight coupling.

*
* Why Do We Need Composition?
✔ Encapsulation – Keeps related objects inside a single entity.
✔ Better Code Reusability – You can change the internal object without affecting the parent class.
✔ Avoids Issues of Inheritance – Inheritance (extends) can lead to tight coupling and fragile hierarchy.
✔ Improves Maintainability – Easier to modify or replace a component without breaking the whole system.


* How to Implement Composition in Java?
Composition is implemented by declaring an instance variable of another class inside a class and
* instantiating it within the constructor.
*
* class Car {
    private final Engine engine; // ✅ Step 1: Declare instance variable of another class

    public Car() {
        this.engine = new Engine(); // ✅ Step 2: Instantiate inside the constructor
    }
 }
* */

//Example 1: Car and Engine (Composition)
//A Car HAS-A Engine, and the Engine cannot exist without the Car.
//A Car HAS-A Engine, meaning Car is the container class, and Engine is the contained object.


// Engine class (Dependent class),Contained Object
class Engine {
    void start() {
        System.out.println("Engine started...");
    }
}

// Car class (Main class),Container Class
class Car1 {
    private Engine engine; // Composition (Car HAS-A Engine)
    //private final Engine engine; // ✅ Contained Object (Created inside Car)


    // Car creates its own Engine (Strong Dependency)
    public Car1() {
        this.engine = new Engine(); // ✅ Engine is created inside Car
    }

    void startCar() {
        engine.start();  // Car uses Engine to start
        System.out.println("Car started...");
    }
}


public class CompositionDemo1 {
    public static void main(String[] args) {
        Car1 car = new Car1(); // Creating a car automatically creates an engine
        //Car car = new Car(); // ✅ Car (Container) owns Engine (Contained Object)
        car.startCar();
    }
}
/*✅ Explanation:

Car (Container Class) → It contains an instance of Engine.
Engine (Contained Object) → It is created inside Car constructor and cannot exist independently.
If we delete Car, the Engine also gets deleted.
*/

//output
//Engine started...
//Car started...
/*
🔍 Why is This Composition?
Car owns Engine.
Engine cannot exist without Car.
If Car is deleted, Engine is also deleted.
*/

/*
* ✅ How do we know it's Composition?
✔ Engine is created inside Car (not passed from outside).
✔ Car owns Engine, and Engine cannot exist without Car.
✔ Engine is private final (cannot be changed externally).

*
* 💡 Final Thought: Prefer Aggregation when possible to keep flexibility,
* but use Composition when objects are strongly dependent on each other.



* */