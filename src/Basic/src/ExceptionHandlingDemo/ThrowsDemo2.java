package ExceptionHandlingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//if no one handle catch exception then then JVM default handleer exception will handle it
// you can see psvmain() handle it
//FileNotFoundException is checked Exception which execute on compile time
public class ThrowsDemo2 {
    public static void m1() throws FileNotFoundException{
        System.out.println("m1");
        m2();
    }
    public static void m2() throws FileNotFoundException{
        System.out.println("m2");
        m3();
    }
    public static void m3() throws FileNotFoundException {
        System.out.println("m3");
        m4();
    }
    public static void m4() throws FileNotFoundException {
        System.out.println("m4");
        File file =new File("demo.tex");// file not found
        Scanner sc= new Scanner(file);
    }

    public static void main(String[] args) throws FileNotFoundException {
        m1();
    }
}
