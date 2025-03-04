package Basic.src.DependencyInjection;

//* 📌 (DI) is very very Important topic which is mostly used in Spring Core in which automatically handle and manage DI
//but here we learned manual handle DI

//-------- What is Dependency Injection (DI)
/*
 * The process of injecting one class object into another object is called DI.
 * In other words,
 * Dependency Injection (DI) is a design pattern used in Java to reduce tight coupling
 * between classes. It allows one class to receive its dependencies from an external
 * source rather than creating them itself.

 *
 * we can perform DI in 3 ways:
 *   a.) setter injection(SI): Injecting dependent object into target object using target class setter method
 *   b.) constructor injection(CI):Injecting dependent object into target object using target class constructor
 *   c.) field injection: Injecting dependent object into target object using target class field/method

* Note: Can we perform both SI and CI for single variable such as Engine eng ? interview ques
*   Answer: Yes, we can do But setter injection override construction injection
* (check SetterAndConstructorTogetherInterviewQues.java example)
* * */

//------------ setter injection -------------
// Injecting dependent object(Engine) into target object using target class(BMWCar) setter method

// Dependency class
interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("To start we need petrol");
    }
}

class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("To start we need Diesel");
    }
}

class BMWCar {
    private Engine engine; // Dependency


    // Setter method for dependency injection
    public void setEngine(Engine engine){
        this.engine=engine;//
    }
    void drive(){
        if (engine != null) {
            engine.start();
            System.out.println("Car is running...");
        } else {
            System.out.println("Engine is not set!");
        }
    }
}

public class SetterInjection {
    public static void main(String[] args) {
        BMWCar car =new BMWCar();

        // Injecting PetrolEngine at runtime
        Engine pe = new PetrolEngine(); //Used Interface for Runtime Polymorphism:
        car.setEngine(pe);
        //car.setEngine(new PetrolEngine()); we can also do that
        car.drive();

        // Injecting DieselEngine at runtime
        Engine de = new DieselEngine(); //Used Interface for Runtime Polymorphism:
        car.setEngine(de);
        car.drive();
    }
}

//✅ When to use?
//When you want to change the dependency at runtime.
//When the dependency is optional.


/*
* 💡 Future Improvements:
If engine is mandatory, use constructor injection instead to avoid calling drive() without setting an engine.
If you're using Spring, you can use @Autowired to automate dependency injection.

* */