package Basic.src.ImmutableObject;
import java.util.*;
/*
* we will not share same reference instead we create new Object for hobbies and getHobbies..
* sothat it will points to different location..
* and by using this approach, Our Student Object will not change.
* */

class Person{
    int id;
    String name;
    List<String> hobbies;

    public Person(int id,String name,List<String> myHobbies){
        this.id=id;
        this.name=name;
        this.hobbies=new ArrayList<>();
        this.hobbies.addAll(myHobbies);

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        List<String> copyHobbies=new ArrayList<>();
        copyHobbies.addAll(hobbies);
        return copyHobbies;
    }
}

public class SolutionForImmutableObject {
    public static void main(String[] args) {

        List<String> myHobbies = new ArrayList<>();
        myHobbies.add("html");

        Person s = new Person(1,"krish", myHobbies);//myHobbies ka reference send ker rehy hai yha s inside constructor
        System.out.println(s); //Person{id=1, name='krish', hobbies=[html]}

        //case 1
        //now try to add new hobbies
        myHobbies.add("java");
        System.out.println(myHobbies);//[html, java]
        System.out.println(s); //Person{id=1, name='krish', hobbies=[html]}
        // Wow great job

        //case 2
        System.out.println("Get person Hobbies after object create" +s.getHobbies());
        List<String> newHobbies=s.getHobbies();
        newHobbies.add("php");
        System.out.println(s.toString());
        //wow..fixed all problem

        // we can acheived by making id,name,hobbies as final..but Interviewer dont want to used final keyword


    }
}
