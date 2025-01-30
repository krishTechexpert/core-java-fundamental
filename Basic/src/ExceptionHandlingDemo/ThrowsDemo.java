package ExceptionHandlingDemo;

public class ThrowsDemo {
    public void m1(){
        m2();
    }
    public void m2(){
        m3();
    }
    public void m3(){
        m4();
    }
    public void m4(){
        System.out.println(10/0);
         //10/0 i.e m4 ny error ko handle nhi kiya toh y caller methods m3 s puchega
        // b'cpz usny call kiya hai m4 ko toh
        //uski responsibility hai error ko handle kerny ki ..same as m2,m1'
        //agar koi bi error handle nhi krega toh
        //JVM us Exception ka object bnakar JVM default exceptional handler ko d deta hai
    }

//    Exception in thread "main" java.lang.ArithmeticException: / by zero
//    at ExceptionHandlingDemo.ThrowsDemo.m4(ThrowsDemo.java:14)
//    at ExceptionHandlingDemo.ThrowsDemo.m3(ThrowsDemo.java:11)
//    at ExceptionHandlingDemo.ThrowsDemo.m2(ThrowsDemo.java:8)
//    at ExceptionHandlingDemo.ThrowsDemo.m1(ThrowsDemo.java:5)
//    at ExceptionHandlingDemo.ThrowsDemo.main(ThrowsDemo.java:19)


    public static void main(String[] args) {
        ThrowsDemo t1=new ThrowsDemo();
        t1.m1();
    }
}
