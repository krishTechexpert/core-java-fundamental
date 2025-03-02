package Coupling;
// with super and using Inheritance extends
// class P contains all method of class M evenif I need only 1 method of class M,
// suppose class M contain 100 methods then class P k pass 100 method aa jyegi using extends but
// class P required only 1 method. so in case, class P has taking extra load

// to handle this situation we need some Aggrgration(loose coupling),Association(tightcoupling) relationship
// check another example TightCouplingDemo

class M {
    public M(){
        System.out.println("M class constructor call");
    }
    public void m1(){
        System.out.println("M:m1()");
    }
}

class P extends M {
    public P(){
        //super();//no need to call super for  no-argument constructor
        // By default, every constructor in a subclass implicitly calls the no-argument constructor of its parent class.
        //Even though we did not write super();, the Java compiler automatically adds it at the beginning of P's constructor.

        // but if we have parameterized constructor in parent class then we have to call super(name) explicitly
        System.out.println("P class constructor call");
        super.m1();//call method of parent class using super
    }
}

public class ProblemStatement {
    public static void main(String[] args) {
        P p=new P();
    }
}
//output
//M class constructor call
//P class constructor call
//M:m1()
