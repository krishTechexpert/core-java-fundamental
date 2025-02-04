package CollectionDemo.Cursor;

import java.util.*;
/*
Enumeration is the cursor which is used to reterive collection objects one by one.
It was introduced with jdk1.0
Use Vector when thread safety is needed.
it can be used only with legacy class such as vector and stack
it can be get by elements() method
vector.elements()

Only allows forward traversal.
✔ Forward-only traversal (hasMoreElements() and nextElement()).
Does not allow element modifications (add, remove, update).
* */
public class EnumerationDemo {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); //[10,20,30];
        Enumeration<Integer> enumeration = list.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
            //10
            //20
            //30
        }

    }
}
