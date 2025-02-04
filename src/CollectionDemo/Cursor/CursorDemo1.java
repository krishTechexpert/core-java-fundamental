package CollectionDemo.Cursor;
import java.util.*;
/*
* In Java, cursors are used to iterate over elements in a Collection.
* Java provides three main types of cursors:

Enumeration (Legacy cursor, only for Vector and Stack,Hashtable)
Iterator (Universal cursor, works with all Collections)
ListIterator (Bidirectional cursor, works only for Lists)
* these 3 are interface.
* */

/*
* 2. Iterator (Universal Cursor)
Introduced in Java 1.2.
Works with all Collection types (List, Set, Queue, etc.).
Only allows forward traversal.
Allows removing elements using remove() but not adding or modifying.
*
* Key Points
✔ Works with all Collection types.
✔ Allows removing elements (remove()).
❌ Only forward traversal.
❌ Cannot modify (set()) or add (add()) elements.

* */
//Example: Using Iterator with ArrayList

/*
* Conclusion
Use Enumeration only for legacy collections (Vector, Hashtable).
Use Iterator for any Collection when you only need forward traversal and removal.
Use ListIterator when working with Lists and needing bidirectional traversal,
* modification, and insertion.

* */

/*
* Use ArrayList when you need fast access and dynamic resizing.
Use LinkedList when frequent insertions/deletions are required.
Use Vector when thread safety is needed.
* */

public class CursorDemo1 {
    public static void main(String[] args) {
     List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
     Iterator<String> itr = list.iterator(); //Returns an array containing all of the elements in this list in proper sequence (from first to last element)
     while(itr.hasNext()){//return true
         String fruit = itr.next();
         if(fruit.equals("Banana")){
             itr.remove();// Removes "Banana"
         }
         System.out.println(fruit);
     }
     System.out.println("After removal: " + list); //After removal: [Apple, Cherry]

    }
}
