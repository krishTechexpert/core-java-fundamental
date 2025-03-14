package InterfaceDemo;
// good concept here used
//Creating interface that has 4 methods
interface A{
    void a();//bydefault, public and abstract
    void b();
    void c();
    void d();
}
//Creating abstract class that provides the implementation of one method of A interface
abstract class B implements A{
    public void c(){System.out.println("I am C");}
}
//Creating subclass of abstract class,
// now we need to provide the implementation of rest of the methods
class M extends B{
    public void a(){System.out.println("I am a");}
    public void b(){System.out.println("I am b");}
    public void d(){System.out.println("I am d");}
}

public class demo2 {
    public static void main(String[] args) {
        A a=new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }
}
