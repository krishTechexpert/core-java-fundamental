package InterfaceDemo;

/*
* Since Java 8, we can have default and static methods in an interface.
Since Java 8, we can have method body in interface.
* But we need to make it default method. Let's see an example:
 *
 * Since Java 8, we can have static method in interface. Let's see an example:

 * *Q) What is marker or tagged interface?
    An interface which has no member is known as a marker or tagged interface,
    *  for example, Serializable, Cloneable, Remote, etc. They are used to provide
    *  some essential information to the JVM so that JVM may perform some useful operation.

    * //How Serializable interface is written?
        public interface Serializable{
        * // no memeber here
        }


 *  */

interface Drawable{
    void draw(); // by default public and abstract
    default void msg(){System.out.println("default method");}
    // here we defined body implementation which is
    // allowed in java8 with default

    static int cube(int x){return x*x*x;}

}
class Rectangle implements Drawable{
    public void draw(){System.out.println("drawing rectangle");}
}

public class Java8InterfaceDemo {
    public static void main(String[] args) {
        Drawable d=new Rectangle();
        d.draw();
        d.msg();
        System.out.println(Drawable.cube(3));

    }
}

