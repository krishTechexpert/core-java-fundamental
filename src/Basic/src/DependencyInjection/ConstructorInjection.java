package Basic.src.DependencyInjection;

//----------ConstructorInjection-----------
/*
*In constructor injection, dependencies are passed via the constructor,
*  making sure they are always set when the object is created.
If dependency is mandatory, use constructor injection.

* ✅ Example: Mobile Phone with Different Processors
A Processor (dependency) is needed for a MobilePhone to function.
We inject different processors (Snapdragon and MediaTek) at runtime.

*
 * */

// Dependency Interface
interface Processor{
    void process();
}
// Snapdragon Processor Implementation
class Snapdragon implements Processor {
    @Override
    public void process(){
        System.out.println("Using Snapdragon Processor for fast performance!");
    }
}

// MediaTek Processor Implementation
class MediaTek implements Processor {
    @Override
    public void process() {
        System.out.println("Using MediaTek Processor for budget performance!");
    }
}

// Dependent Class: MobilePhone
class MobilePhone{
    private Processor processor; // Dependency

    public MobilePhone(Processor p){
        this.processor=p;
    }
    void start(){
        processor.process();
        System.out.println("Mobile Phone is starting...");

    }
}

public class ConstructorInjection {
    public static void main(String[] args) {
        // Injecting Snapdragon processor at runtime
        /*
        * ✅ Good approach (Recommended) – Uses Polymorphism
        * 1️⃣ Approach 1 (Using Interface Reference)

                 Processor p = new Snapdragon();
                The variable p is declared as type Processor (the interface),
*               but holds an object of Snapdragon (a concrete class).
                This allows us to easily switch implementations at runtime.
                We can assign any other implementation of Processor without changing existing code.
                *
                * Example of Flexibility:
                * p = new MediaTek(); // No change in code structure

        * */
        Processor p = new Snapdragon();
        //Snapdragon s = new Snapdragon();
        MobilePhone phone1 = new MobilePhone(p);
        phone1.start();

        /*
        * 2️⃣ Approach 2 (Using Concrete Class Reference)
                Snapdragon s = new Snapdragon();
            🚫 Not recommended (Less flexible)
                    s is tied to the specific Snapdragon class.
                    If we want to use MediaTek instead, we must change the variable type everywhere.
            ❌ Without Polymorphism (Tightly Coupled Code)
                // Concrete class reference (BAD APPROACH)
                class MobilePhone {
                    private Snapdragon processor; // Directly using a specific class

                    public MobilePhone() {
                        this.processor = new Snapdragon(); // Hardcoded dependency
                    }

                    void start() {
                        processor.process();
                        System.out.println("Mobile Phone is starting...");
                    }
                }

                // Main class
                public class WithoutPolymorphism {
                    public static void main(String[] args) {
                        MobilePhone phone = new MobilePhone();
                        phone.start();
                    }
                }
            Problem in the Above Code:
The MobilePhone class depends directly on Snapdragon.
If we want to switch to MediaTek, we must edit the MobilePhone class itself.
This breaks Open/Closed Principle (O in SOLID) - The class should be open for extension but closed for modification.

        *
        * 🔍 Key Takeaway
🚀                Always use interface reference (Processor p = new Snapdragon();)
                * instead of a concrete class reference (Snapdragon s = new Snapdragon();).
                This makes your code flexible, maintainable, and easily extensible. 😊
        * */

        System.out.println("----------------------");

        // Injecting MediaTek processor at runtime
        Processor mediatek = new MediaTek();
        MobilePhone phone2 = new MobilePhone(mediatek);
        phone2.start();

    }
}
//Output
/*
* Using Snapdragon Processor for fast performance!
Mobile Phone is starting...
----------------------
Using MediaTek Processor for budget performance!
Mobile Phone is starting...

* */

/*
* ✅ Why Constructor Injection?
1️⃣ Ensures dependency is always set (cannot create MobilePhone without a processor).
2️⃣ Encourages immutability (processor cannot be changed after object creation).
3️⃣ Better for mandatory dependencies (a phone must have a processor).

* */