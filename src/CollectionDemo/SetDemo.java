package CollectionDemo;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
/*
* Understanding Set in Java Collection
  A Set in Java is a collection that does not allow duplicate values.
* Unlike List, Set does not guarantee insertion order (except for some specific implementations).

* Types of Set and How They Store Values
HashSet → Unordered, fast lookup (uses HashMap internally)
LinkedHashSet → Maintains insertion order
TreeSet → Stores elements in sorted order (uses Red-Black Tree)
* */

/*
* 1. HashSet (Unordered, No Duplicates)
Uses a HashMap internally to store elements.
Does not maintain insertion order.
Allows one null value.
* */

/*
* How HashSet Stores Values
Internally, HashSet uses a HashMap where:
The set value is stored as the key in the HashMap.
The value in the HashMap is a constant placeholder (Object).
Index (Hash)	Key (Value)	    Value (Placeholder)
1234	        "Apple"	        PRESENT
5678	        "Banana"	    PRESENT
9101	        "Cherry"	    PRESENT
3456	        null	        PRESENT
When adding an element, it calculates a hash and stores it at that index.
Duplicates are ignored because if the hash already exists, it won’t be added again.

* */

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate ignored
        set.add(null); // only one Null is allowed
        set.add(null); // Null is allowed but it store only one null as Duplicate not allowed

        // Printing the set
        System.out.println("HashSet: " + set);
        //HashSet: [null, Apple, Cherry, Banana]

        //Possible Output (Order not guaranteed)
        //HashSet: [Banana, Apple, Cherry, null]

        //how we can iterator of HashSet element
        //we can iterate by using only iterator() in hashSet

        Iterator itr = set.iterator();// contain all element of set
        while(itr.hasNext()){
            System.out.println(itr.next());
            //null
            //Apple
            //Cherry
            //Banana
        }
    }
}
