package ExceptionHandlingDemo;
//here m2 catch exception
public class ThrowsDemo1 {
    public void m1(){
        m2();
    }
    public void m2(){
        try{
            m3();
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    public void m3() throws ArithmeticException{
        m4();
    }
    public void m4() throws ArithmeticException {
        System.out.println(10/0);
         //10/0 i.e m4 ny error ko handle nhi kiya toh y caller methods m3 ko exception
        // throws ker dega b'coz m3 ny call kiya tha m4 ko
        //m3 ki  responsibility hai error ko handle kerny ki ..same as m2,m1'
        //agar koi bi error handle nhi krega toh
        //JVM us Exception ka object bnakar JVM default exceptional handler ko d deta hai
    }
    public static void main(String[] args) {
        ThrowsDemo1 t1=new ThrowsDemo1();
        t1.m1();
    }
}
