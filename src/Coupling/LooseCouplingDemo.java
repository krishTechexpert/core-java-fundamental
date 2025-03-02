package Coupling;

class M2 {
    public M2(){
        System.out.println("M2 class constructor call");
    }
    public void show(){
        System.out.println("M2:show()");
    }
}

class P2 {
    M2 a1; // a1 is the instance varaible which will hold M2 class object
    public P2(M2 m){
        System.out.println("P2 class constructor call");
        a1=m; // Aggrgration (it provde fexibility) recommed approach
    }
}

public class LooseCouplingDemo {
    public static void main(String[] args) {
        P2 p=new P2(new M2());// here we can passed any object it will not break P2 funcationality
        p.a1.show();

        /*
        * Your code correctly implements Aggregation because:

The M2 object is created outside and passed as a parameter to P2.
P2 only holds a reference to M2 instead of creating it.
M2 can exist independently of P2.

        * */
    }
}
//output
//M2 class constructor call
//P2 class constructor call
//M2:show()

