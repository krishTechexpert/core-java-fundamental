class Animal{
    String color="white";
    void eat(){
        System.out.println("Eating...");
    }
}

class Dog extends Animal{
    String color="Black";
    void print(){
        System.out.println(color);// print color of Dog class
        System.out.println(super.color); //print color of animal class
    }
    void eat(){
        System.out.println("dog eating bread...");
    }
    void bark(){
        System.out.println("dog Barking...");
    }

    void work(){
        bark(); // dog barking...
        eat(); // dog eating bread
        super.eat(); // Eating...
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.print();
        d.work();
    }
}
