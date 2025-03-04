package Basic.src.DependencyInjection;

/*
*
* Can We Perform Both Setter Injection (SI) and Constructor Injection (CI) for a Single Variable?
Yes, we can perform both (SI) and  (CI) for the same variable (e.g., Engine eng).
*  However, it's generally not recommended because it creates ambiguity about which
* method should be used to inject the dependency.

*
* 🚨 Why This is Not Recommended?
Inconsistent state – If someone uses both CI and SI, it’s unclear which should take priority.
Breaks immutability – Constructor-injected dependencies should ideally be final and immutable.
Confusion in frameworks (e.g., Spring) – It may lead to unexpected behavior if both constructor and setter are used.

*
* */


// Engine Interface
interface ENgine {
    void start();
}

// Petrol Engine Implementation
class PetrolENgine implements ENgine {
    @Override
    public void start() {
        System.out.println("Using Petrol Engine...");
    }
}

// Diesel Engine Implementation
class DieselENgine implements ENgine {
    @Override
    public void start() {
        System.out.println("Using Diesel Engine...");
    }
}

// Car class with both Constructor and Setter Injection
class Car {
    private Engine engine; // Dependency

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("Engine injected via Constructor: " + engine.getClass().getSimpleName());
    }

    // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Engine injected via Setter: " + engine.getClass().getSimpleName());
    }

    void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Car is running...");
        } else {
            System.out.println("No engine found!");
        }
    }
}

// Main Class
public class SetterAndConstructorTogetherInterviewQues {
    public static void main(String[] args) {

        // Constructor Injection
        Engine petrolEngine = new PetrolEngine();
        Car myCar = new Car(petrolEngine);

        // Check which engine is being used
        myCar.drive();

        System.out.println("----------------------");

        // Setter Injection (Overriding Constructor Injection)
        Engine dieselEngine = new DieselEngine();
        myCar.setEngine(dieselEngine);

        // Check which engine is being used after Setter Injection
        myCar.drive();

    }
}
//output
/*
* Engine injected via Constructor: PetrolEngine
Using Petrol Engine...
Car is running...
----------------------
Engine injected via Setter: DieselEngine
Using Diesel Engine...
Car is running...

* */