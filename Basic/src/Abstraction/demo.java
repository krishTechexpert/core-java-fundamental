package Abstraction;
/*Real-World Example of Abstraction Using an Abstract Class (Animal Example)
Let's say we are building a program for a zoo management system.
Different animals have different ways of making sounds,
but all animals share some common behaviors, such as eating.

To model this, we can create an abstract class Animal,
which defines a common structure but leaves the implementation of makeSound() to the
 subclasses.
*/
// Abstract class representing an Animal
abstract class Animal{
    static String bradth="by mouth";
    String name;
    // Constructor
    Animal(String name){
        this.name=name;
    }
    // Abstract method (must be implemented by subclasses)
    public abstract void makeSound();

    // Concrete method (common behavior)
    public void eat(){
        System.out.println(name + " is eating");
    }
}

// Subclass representing a Dog
//subclass need to override all abstract method of abtsract class
//Explanation: If a subclass does not implement all abstract methods of an abstract class,
//it must be declared abstract itself, otherwise, a compile-time error occurs.

//3. Can an abstract class have static methods in Java?
//Explanation: Abstract classes can have static methods, which can be called without
// creating an instance of the class. These methods are not tied to any specific
// instance of the abstract class.




class Dog extends  Animal{

    //constructor
    Dog(String name){
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

// Subclass representing a Cat
class Cat extends Animal{
    Cat(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

public class demo {

    public static void main(String[] args) {


       //Animal a = new Animal(); // java: Abstraction.Animal is abstract; cannot be instantiated
        // Creating a Dog object
        Animal dog = new Dog("Buddy"); // Dispatch binding good approach
        // work well b'coz Parent class can contain reference of child class
        // we already study
        //Dog dog = new Dog("bullDog");
        dog.makeSound();
        dog.eat();

        System.out.println("----------------------");

        // Creating a Cat object
        Animal cat = new Cat("Whiskers");
        //Cat cat = new Cat("");//it is also work well.
        cat.makeSound();
        cat.eat();

        System.out.println(Animal.bradth);
    }

}
