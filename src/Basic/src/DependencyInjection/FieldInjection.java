package Basic.src.DependencyInjection;

/*
* 👉 ---------- Field Injection-------------
In field injection, we directly assign the dependency using reflection or frameworks (like Spring).

✅ When to use?

When using a framework like Spring, which automatically injects dependencies.
Not recommended for pure Java because dependencies are hidden.

*
* 🚀 Best Practice:
👉 Use Constructor Injection for mandatory dependencies.
👉 Use Setter Injection for optional dependencies.
👉 Avoid Field Injection in pure Java unless using a framework like Spring.


 * */

import java.lang.reflect.Field;

// Dependency class
class ENGine {
    void start() {
        System.out.println("Engine started...");
    }
}

// Dependent class
class CAr {
    //@javax.inject.Inject // In Spring, we use @Autowired
     private ENGine engine; // Dependency injected directly
// don't make argument constructor for reflection otherwise give error
    void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Car is running...");
        } else {
            System.out.println("Engine is not set!");
        }
    }
}

// Main class (Manual injection needed)

public class FieldInjection {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        CAr car = new CAr();
//        ENGine engine = new ENGine();
//
//        // Manual injection (not recommended in pure Java)
//        car.engine = engine; // Directly assigning the dependency
//        car.drive();

        // If we make private ENGine engine, then we can not used outside CAr class. how can break rule..
        // we can used reflection API , when we want private member outside of class
        //let us see Field dependecny injection with reflection
       Class<?> cl =  Class.forName("Basic.src.DependencyInjection.CAr"); // es class ko load ker wa reha hu, and hold ker reha hu class type k object mai
       //? means represent generic, mujko nhi pata y class ka type kiya hai

        //reflection topic deprecated (since="java 9") hota ja reha hai in some java version
        Object obj = cl.newInstance();
        CAr car =(CAr) obj;
        Field field = cl.getDeclaredField("engine");  //engine varaible
        field.setAccessible(true);

        field.set(car,new ENGine());
        car.drive();
    }
}
