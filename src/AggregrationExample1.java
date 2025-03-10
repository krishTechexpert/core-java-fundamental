/*
* ---------- What is Aggregation? ----------
 *Aggregation is a form of association in OOP where an object of one class contains a reference to
 * an object of another class. However, the contained object can exist independently of the container. This means that even if the container object is destroyed, the contained object can still be used elsewhere in the application.
*
* https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/aggregation
*
*
* Key Characteristics of Aggregation:
    Represents a has-a relationship.
    The contained object can exist independently of the container.
    Implemented using references (pointers) to objects.
    Promotes loose coupling between objects.

    * inheritance, which establishes an "is-a" relationship,
    * composition/Aggregation/Association represents a "has-a" relationship.
*
* */

//Example: A University and its Professors
//4. Real-World Applicability
//Many real-world relationships,
// such as a school and its teachers,
// a company and its employees, naturally fit the aggregation model.

import java.util.ArrayList;
import java.util.List;

class Professor{
    private String name;
    private String subject;

    public Professor(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    public void teach(){
        System.out.println(name +" is teaching " +subject);
    }

    public String getName(){
        return name;
    }
}

class University {
     private String name;
     private List<Professor> professors;

     public University(String name){
         this.name=name;
         this.professors=new ArrayList<>();
     }

     public void add(Professor p){
         professors.add(p);
     }

    public void showProfessors() {
        System.out.println("Professors at " + name + ":");
        for (Professor professor : professors) {
            System.out.println(" - " + professor.getName());
        }
    }


    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}

public class AggregrationExample1 {
    public static void main(String[] args) {
        University uni = new University("AKTU");
        Professor p1 =new Professor("krish","Math");
        Professor p2 =new Professor("ravi","Computer");
        uni.add(p1);
        uni.add(p2);

        uni.showProfessors();

        // Professors can exist independently
        p1.teach();
        p2.teach();

    }
}
