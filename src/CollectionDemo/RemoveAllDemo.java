package CollectionDemo;
import java.util.ArrayList;
import java.util.Collection;
public class RemoveAllDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(3);//Duplicate allowed
        list1.add(null);//Null allowed
        System.out.println(list1);//[1,2,3,4,5];

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        System.out.println(list2); //[2,4]

        //please remove lists [2,4] element from list1
        System.out.println("after removing...");
        list1.removeAll(list2);
        //Removes 2 and 4 from list1 because they exist in list2.
        System.out.println(list1);//[1,3,5]
        System.out.println(list2);//[2,4]

        //Note:
        //It does not remove elements inside nested lists.
        //If an element is a nested list, it won’t be removed unless the
        // exact same nested list exists in the collection.
    }
}
