package CollectionDemo;
import java.util.ArrayList;
import java.util.Collection;
/*
* List is an index based structure
* List contain duplicate values
* List can contain multiple null value
* List allow the insertion order
* we can iterate (get) the list element by Iterator and ListIterator
*
* Iterator and ListIterator are both used to traverse elements
*
* 1. Iterator (Single-Directional)
Used to iterate over any Collection (List, Set, Queue, etc.).
Traverses only in one direction (forward).
Can remove elements using remove(), but cannot modify or add elements.
Works with List, Set, Queue, etc.

* 2. ListIterator (Bi-Directional, More Features)
Only works with List (ArrayList, LinkedList, etc.).
Can traverse in both directions (forward & backward).
Can add, modify, and remove elements while iterating.
Provides previous() method to traverse in reverse order.

*
* Key Differences: Iterator vs. ListIterator
Feature	        Iterator	             ListIterator
Applicable To	Works with List,  |       Set, Queue	Only works with List
Direction	    Forward-only (next()) |	 Both directions (next(), previous())
Modification	Can remove elements (remove()) |	Can add (add()), modify (set()), and remove (remove()) elements
Index Access	No index access |	Provides nextIndex() and previousIndex()

* */
public class FirstDemo {
    public static void main(String[] args) {
        ArrayList a1 = new ArrayList();
        a1.add(10);
        a1.add("krish");
        a1.add(4.50);
        a1.add(true);
        a1.add('c');
        System.out.println(a1);//[10, krish, 4.5, true, c]
        System.out.println(a1.get(1));//krish ie. called iterator

        ArrayList b1 = new ArrayList();
        b1.add(200);
        b1.add(300);

        b1.addAll(a1);// it will add all element of a1 into b1
        System.out.println(b1); //[200, 300, 10, kris, 4.5, true, c]

        System.out.println(a1.add(1000)); //true means element added in a1
        System.out.println(a1);//[10, kris, 4.5, true, c, 1000];
        System.out.println(a1.contains(4.50));//true

        ArrayList c1 = new ArrayList();
        c1.add(10);
        c1.add("aaa");
        c1.add(20);
        c1.add(10);
        System.out.println(c1); //[10, aaa, 20, 10]
        //c1.remove(10); // 10 treat as index here //Index 10 out of bounds for length 4
        c1.remove(0);// remove first occourance element, need to  give index, remove(index i) method of ArrayList
        System.out.println(c1);//[aaa, 20, 10]
        c1.remove("aaa"); //remove(Object o) collection ka method hai
        System.out.println(c1); //[20,10]

        ArrayList d1 = new ArrayList();
        d1.add(10);
        d1.add(c1);
        System.out.println(d1);//[10, [20, 10]];
        d1.removeAll(c1); //removes from this list all of its elements
        // that are not contained in the specified collection.
        //removeAll(c1) attempts to remove all elements in c1 (20, 10) from d1.
        //d1 contains 10 as a standalone element and c1 as a nested list.
        //The standalone 10 matches an element in c1, so it is removed.
        //The nested list [20, 10] does not match exactly with any element in c1,
        // so it remains in d1.
        System.out.println(d1);//Output: [[20, 10]];




    }
}
