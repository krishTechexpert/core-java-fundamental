package CollectionDemo;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
/*
* A List in Java is an ordered collection that maintains insertion order and
* allows duplicates.
* */
//1. Using ArrayList
// An ArrayList internally uses a dynamic array to store elements.
// it store value like an Array , index based sequential order
/*How It Stores Data
Index	Value
0	    Apple
1	    Banana
2	    Cherry
3	    Apple
4       null
5       null
       ArrayList maintains insertion order.
       Duplicates are allowed.
       Internally, ArrayList uses an array and grows/srink dynamically when needed.
*/

/*
* Conclusion
Use ArrayList when you need fast access O(1) and dynamic resizing.
Use LinkedList when frequent insertions/deletions are required.
Use Vector when thread safety is needed.
* */
public class ListDemo {
    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> list = new ArrayList<>();
        // Adding elements
        //list.add(0,"kiwi") // zero index per kiwi add ker dega..
        list.add("Apple");// automatically array index per Apple add ker deha 0-apple
        list.add("Banana");
        list.add("Cherry");
        list.add("Apple"); // Duplicates allowed
        list.add(null); // Multiple Null value allowed
        list.add(null);

        // Printing the list
        System.out.println("List: " + list);
        //List: [Apple, Banana, Cherry, Apple, null, null]

        //how we can iterator of ArrayList element
        //we can iterate by using iterator() or listIterator in ArrayList

        //way 1 read and remove element in forward direction
        Iterator itr = list.iterator();// contain all element of list
        while(itr.hasNext()){
            System.out.println(itr.next());//Apple
            //Banana
            //Cherry
            //Apple
            //null
            //null
        }
        //way-2 traverse to backward and forward element and read,add,remove,replace element
        ListIterator itr1 = list.listIterator();// contain all element of list
        while(itr1.hasNext()){
            System.out.println(itr1.next());//Apple
            //Banana
            //Cherry
            //Apple
            //null
            //null
        }
    }
}
