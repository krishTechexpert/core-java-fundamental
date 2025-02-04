package CollectionDemo.Cursor;
import java.util.*;
/*
* 3. ListIterator (Bidirectional Cursor)
Introduced in Java 1.2.
Works only with List (ArrayList, LinkedList, etc.).
Allows both forward and backward traversal.
Allows modification (set()), addition (add()), and removal (remove()).
* */
//Example: Using ListIterator with ArrayList

/*
* Key Points
✔ Works only with List.
✔ Supports both forward and backward traversal.
✔ Allows removing, modifying, and adding elements.
❌ Not available for Set or Queue.
* */

/*
* Use ArrayList when you need fast access and dynamic resizing.
Use LinkedList when frequent insertions/deletions are required.
Use Vector when thread safety is needed.
* */

public class CursorDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        ListIterator<String> itr = list.listIterator();

        //Forward iteration
        while(itr.hasNext()){
           String fruit =  itr.next();
           if(fruit.equals("Banana")){
               itr.set("Blueberry"); // Replace "Banana" with "Blueberry"
               itr.add("Orange");//add new fruit
               System.out.println(fruit);
           }
        }
        System.out.println(list);// [Apple, Blueberry, Orange, Cherry]
        // yha per mere cursor ki position last hai after cherry,
        // Backward iteration
        //,ab yha s reverse krega
        // or cursor ki position top per chali jygi before apple
        while (itr.hasPrevious()) {
            System.out.println("Reverse: " + itr.previous());
//            Reverse: Cherry
//            Reverse: Orange
//            Reverse: Blueberry
//            Reverse: Apple
        }

        System.out.println("After modification: " + list);
        //After modification: [Apple, Blueberry, Orange, Cherry]
    }
}
