package Coupling;
//  suppose class M contain 100 methods
// class P required only 1 method..so in case

// to handle this situation without inheritance,
// we can used Association(tight coupling) relationship to acheive this

// If you can also used Aggregration (loose coupeling demo),
//it depends on your client requirement,he want application tight,loose coupling based

//------------ tight coupling ---------------

class M1 {
    public M1(){
        System.out.println("M1 class constructor call");
    }
    public void show(){
        System.out.println("M1:show()");
    }
}

class P1 {
    M1 a1; // a1 is the instance varaible which will hold M1 class object
    public P1(){
        System.out.println("P1 class constructor call");
        a1 = new M1(); // ❌ Object is created INSIDE P1 constructor → This is Composition!

        /*Here, P1 creates an instance of M1 inside its constructor.
        This means P1 is responsible for M1’s lifecycle (tight coupling).
        If P1 is destroyed, M1 is also destroyed → Composition.*/
        // for better explanation check RelationshipDemo also
        //In Future, suppose In parent class , we update parameterized constructor public M1(String name) then
        // our P1 class need to update it such as a1 = new M1("Ram);
        // this is called tight coupling i.e both classes to depends on each other

    }
}

public class TightCouplingDemo {
    public static void main(String[] args) {
        P1 p=new P1();
        p.a1.show();
    }
}
//output
//P1 class constructor call
//M1 class constructor call
//M1:show()
