package Basic.src.ImmutableObject;
import java.util.*;
/* Interview Question : Make an Object Immutable
Immutable Object: once object is created then value of its instance member of that object should never be changed
We can do by making final instance varaible.but we are doing this without final.
very interesting concept.

*/

class Student{
 int id;
 String name;
 List<String> hobbies;

 public Student(int id,String name,List<String> h){
     this.id=id;
     this.name=name;
     this.hobbies = h;
 }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void addHobbies(String h){
         this.hobbies.add(h);
     }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}


public class WithoutImmutable {


    public static void main(String[] args) {
        List<String> myHobbies = new ArrayList<>();
        myHobbies.add("html");


        Student s = new Student(1,"krish", myHobbies);//myHobbies ka reference send ker rehy hai yha s inside constructor
        //both s.hobbies , myHobbies points to same memory location
        System.out.println(s.toString()); //Student{id=1, name='krish', hobbies=[html]} it should not change after creating object

        /******************************************************/
        // case 1 : problem with setter method
        // s.setName("max"); // dont'used setter b'coz it will change name of student object
        // that we don't want. so remove all setter method
        // name will change with setter
        //Student{id=1, name='max', hobbies=[html]} // problem
        /******************************************************/


        /******************************************************/
        //Case 2: here, without student touch , we try to update myHobbies
        // then Student hobbies will also updated so yha per student object change ho gya hai..problem
        //myHobbies.add("java");
        //System.out.println(s.toString());//Student{id=1, name='krish', hobbies=[html, java]}
        /******************************************************/


        //case 3:
         List<String> copyHobies  = s.getHobbies();//same reference will be shared so it will reflect changes in student object
        System.out.println(copyHobies); //[html]
        copyHobies.add("javascript");
        System.out.println(s.toString());// Student{id=1, name='krish', hobbies=[html, javascript]}

        //These 3 case has problem inwhich our Student object has changes after creation.
        // to fixed these problem check SolutionForImmutableObject.java files
    }
}
