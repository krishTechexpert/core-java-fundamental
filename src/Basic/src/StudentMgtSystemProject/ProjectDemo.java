package StudentMgtSystemProject;

/*
* 🎯 Let's Build a Small Project - "Student Management System"
We’ll create a Student Management System where:
✔️ We create Student objects.
✔️ We use Encapsulation to keep student details private.
✔️ We use Abstraction to hide internal logic.
✔️ We use Inheritance for different types of students.
✔️ We use Polymorphism so different students can introduce themselves in different ways.
* */
//📌 Step 1: Create an Abstract Class (Abstraction)
//This class defines common methods for all students but hides some details.

// person may be student and teacher
 abstract class Person {
    private String name; // Encapsulation
    private int age;
    final String collegeName="DPS";
   // set name and age
   public Person(String name,int age){
       this.name=name;
       this.age=age;
   }
   //get ane and age using getter method
   String getName(){return name;}
   int getAge(){return age;} ;

   // student and teacher apny apny hisaab sy introduce ker sekty jai isliye making abstract
    abstract void introduce();

    //student and teacher ko book allowed hogi as per rule
    // Abstract method (must be implemented by subclasses)
    abstract void booksAllowed(int book);

    // we can add some common method for Each person
    public void BusFacility(){
        System.out.println("Bus facility will be provided to "+ collegeName + "College to the "+name);
    }
}

//📌 Step 2: Create the Student Class (Encapsulation)
// Inherits from Person (Inheritance)

class Student extends Person{
    private final String studentId; // Encapsulation

    Student(String name,int age,String id){
         super(name,age);
         this.studentId="STD-"+id;
     }

     public String getStudentId(){ return studentId;}

     public void booksAllowed(int book){
         System.out.println(getName() + " can take books upto "+ book+" times");
     }

    // Implement abstract method (Polymorphism)
    @Override
    public void introduce(){
         System.out.println("Hi, I am " + getName() + " and I am " + getAge() +", a student with ID: " + getStudentId());
     }
}


//📌 Step 3: Create the Teacher Class (Polymorphism)
//person is the entitty which will be used in different-2 forms such as Student,Teacher,Library emp etc.
// Inherits from Person (Inheritance)

class Teacher extends Person{
    private final String teacherId;
    private String subject;

    public Teacher(String name,int age, String id, String subject){
        super(name,age);
        this.teacherId="Teacher-"+id;
        this.subject=subject;
    }

    public String getSubject() { return subject; }

    // Implement abstract method (Polymorphism)
    @Override
    public void introduce() {
        System.out.println("Hello, I am " + getName() + ", a teacher. I teach " + getSubject() + " and I am " + getAge()+ "year old."+ ", a teacher with ID: " + teacherId);
    }
    @Override
    public void booksAllowed(int book){
        System.out.println(getName() + " can take books upto "+ book+" times");
    }

}

//📌 Step 4: Test the Project in Main Class

public class ProjectDemo {
    public static void main(String[] args) {
        Person student = new Student("Raj",20,"100");
        student.introduce(); //(Polymorphism in action!)
        student.booksAllowed(3); //(Polymorphism in action!)
        student.BusFacility();
        /* Results:
        Hi, I am Raj and I am 20, a student with ID: STD-100
        Raj can take books upto 3 times
        Bus facility will be provided to DPSCollege to the Raj*/

        Person teacher = new Teacher("Vipin",35,"500","English");
        teacher.introduce();
        teacher.booksAllowed(10);
        teacher.BusFacility();
        /* Result:
        Hello, I am Vipin, a teacher. I teach English and I am 35year old., a teacher with ID: Teacher-500
        Vipin can take books upto 10 times
        Bus facility will be provided to DPSCollege to the Vipin*/

    }
 }


 /*
 * 🎯 OOP Principles Used in This Project
✅ Encapsulation – Used private variables and getter methods.
✅ Abstraction – Used an abstract class to define common behavior.
✅ Inheritance – Student and Teacher inherit from Person.
✅ Polymorphism – introduce(),booksAllowed()  method behaves differently in Student and Teacher.

🚀 Why Is This Useful?
✔️ Easier to maintain – If we need a Staff class, we just extend Person.
✔️ Flexible – We can add new behaviors without changing existing code.
✔️ Reusability – The Person class code is used by both Student and Teacher.

 *
 * */