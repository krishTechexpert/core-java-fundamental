package Basic.src.RelationshipDemo;

/*
* What is the IS-A Relationship in Java?
The IS-A relationship in Java represents inheritance (or generalization) between a subclass (child)
* and a superclass (parent).
* It indicates that one class inherits properties and behavior from another class.

This relationship is established using:

extends (for class inheritance)
implements (for interface implementation)

*
* IS-A Relationship Causes tightCoupling issues ,
* suppose in future we make Animal and eat method abstract  then we have to make chnages in child Dog class.
* suppose if you change parameterized ocnstructor in parent class then child class need to update constructor arguments as well.
* */

class Animal {//parent class
    void eat(){
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {// Dog IS-A Animal
    void bark() {
        System.out.println("Dog barks.");
    }
}

public class IsARelationshipDemoWithClass {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Inherited from Animal
        dog.bark(); // Dog's own method
    }
}

//This animal eats food.
//Dog barks.
//Dog extends Animal, meaning Dog IS-A Animal.
//The Dog class inherits the eat() method from Animal.

