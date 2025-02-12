package Basic.src.ExceptionHandlingDemo;
// what if parent class raise some exception then child class has optional to handle exception or not. child class has no exception
// But if child class has raised exception then Parent class need to  manadatory  handle exception
class Parent{
    //public void m1() throws Exception {
    final int a=10;
    public void m1()  {
        System.out.println("Parent m1");
    }
    public static void m2(){
        System.out.println("parent static m1");
    }
}

class Child extends Parent{
    //public void m1() throws Exception {

        @Override
    public void m1()  {
        System.out.println("child m1");
    }
}

public class ParentChild {
    public static void main(String[] args) {
        Parent p = new Child();
        p.m1();
    }
}

