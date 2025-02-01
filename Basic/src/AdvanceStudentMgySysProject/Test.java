package AdvanceStudentMgySysProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/*
* 🚀 New Features to Add
✅ Manage multiple students and teachers using an ArrayList.
✅ Allow searching for a student by ID.
✅ Allow adding courses for students.
✅ Display all students and teachers in the system.
* */

//📌 Step 1: Update the Person Class
//We'll add a unique ID for every person.

abstract class Person {
    private final String id;
    private String name;
    private int age;

    Person(String name,int age){
        this.id= UUID.randomUUID().toString(); // Generate unique ID
        this.name=name;
        this.age=age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public abstract  void introduce();
}

//📌 Step 2: Update the Student Class to Support Courses
//We'll allow students to enroll in courses using an ArrayList.
//ArrayList course --> ["html","java"]
class Student extends Person{
    private String studentId;
    private ArrayList<String> courses; // List of courses
    private HashMap<String,String> enrollCourse; // Course name -> Teacher name

    public Student(String name,int age){
        super(name,age);
        this.studentId=getId();
        this.courses = new ArrayList<>();
        this.enrollCourse=new HashMap<>();
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void addCourse(String course){
        courses.add(course);
        //System.out.println(getName() + " enrolled in " + course);
    }

    public void buyCourse(String courseName, Teacher teacher){
        enrollCourse.put(courseName,teacher.getName());
        System.out.println(getName() + " enrolled in " + courseName + " with " + teacher.getName());
    }

    public void displayCourses() {
       // System.out.println(getName() + "'s Courses: " + courses);
        System.out.println(getName() + "'s Courses:");
        for (String course : enrollCourse.keySet()) {
            System.out.println(getName()+" enroll in " + course + " (Teacher: " + enrollCourse.get(course) + ")");
            //krish enroll in java (Teacher: tapesh)
        }
    }

    @Override
    public void introduce() {
        System.out.println(enrollCourse); // {java=tapesh}
        System.out.println("ID: " + studentId + ", Name: " + getName() + ", Age: " + getAge() + ", Courses: " + courses +  "," + " Enroll Course: " +enrollCourse);
        //System.out.println("Hi, I am " + getName() + " I am "+ getAge()+ " old, a student with ID: " + studentId);
    }
}
//📌 Step 3: Update the Teacher Class
//We'll add a list of courses the teacher teaches.

class Teacher extends Person{
    private String teacherId;
    private ArrayList<String> subjects;
    Teacher(String name,int age){
        super(name,age);
        this.teacherId=getId();
        this.subjects = new ArrayList<>();
    }
    public void addSubject(String subject){
        subjects.add(subject);
        System.out.println(getName() + " is now teaching " + subject);
    }
    public void displaySubjects() {
        System.out.println(getName() + "'s Subjects: " + subjects);
    }

    public ArrayList<String> getSubjects(){
        return subjects;
    }

    @Override
    public void introduce(){
        System.out.println("ID: " + teacherId + ", Name: " + getName() + ", Age: " + getAge() + ", Subjects: " + subjects);
        //System.out.println("Hello, I am " + getName() + ", a teacher. and I teache multiple subjects: "+subjects);
    }

}

//📌 Step 4: Create the SchoolManagementSystem Class
//This class will store and manage students & teachers.

class SchoolManagementSystem {
   private ArrayList<Student> students;
   private ArrayList<Teacher> teachers;
   public SchoolManagementSystem(){
       this.students = new ArrayList<>();
       this.teachers = new ArrayList<>();
   }
   public void addStudent(Student s){
    students.add(s);
    //System.out.println("Student added: " + s.getName());
   }

    public void addTeacher(Teacher t){
        teachers.add(t);
    }

   public void displayAllStudents(){
       System.out.println("\nAll Students:");
        for(Student s : students){
            s.introduce();
        }
   }
   //Find student list who study java
   public void FindStudents(String course){
       for(Student std : students){
           if(std.getCourses().contains(course)){
               System.out.println(std.getName());
           }
       }
   }

    public void displayAllTeachers(){
        System.out.println("\nAll Teachers:");
        for(Teacher t : teachers){
            t.introduce();
        }
    }
    //Find teacher List who teach java subject
    public void FindTeachers(String subject){
        for(Teacher t : teachers){
            if(t.getSubjects().contains(subject)){
                System.out.println(t.getName());
            }
        }
    }

}

public class Test {
    public static void main(String[] args) {

       Student std1 =  new Student("krish",20);
       std1.addCourse("HTML");
       std1.addCourse("java");
       //std1.displayCourses();
       //std1.introduce();

        Student std2 =  new Student("manshi",19);
        std2.addCourse("CSS");
        std2.addCourse("javaScript");
        std2.addCourse("java");
        //std2.displayCourses();
        //std2.introduce();


        Teacher t1 = new Teacher("tapesh",35);
        t1.addSubject("java");
        t1.addSubject("css");
        std1.buyCourse("java",t1);
        std2.buyCourse("java",t1);

        System.out.println("-------Enroll------ ");
        std1.displayCourses();

        Teacher t2 = new Teacher("Akansha",28);
        t2.addSubject("java");
        t2.addSubject("HTML");

        Teacher t3 = new Teacher("Jagat",45);
        t3.addSubject("java");
        t3.addSubject("javascript");
        t3.introduce();

        SchoolManagementSystem sms = new SchoolManagementSystem();
        sms.addStudent(std1);
        sms.addStudent(std2);
        sms.displayAllStudents();

        //All Students:
        //ID: 39c1d2ae-1bf5-4178-8577-89810d05e509, Name: krish, Age: 20, Courses: [HTML, java]
        //ID: eb625125-8a0e-4b7b-98a4-bfca4de590fb, Name: manshi, Age: 19, Courses: [CSS, javaScript]

        sms.addTeacher(t1);
        sms.addTeacher(t2);
        sms.addTeacher(t3);
        sms.displayAllTeachers();
        //All Teachers:
        //ID: 4548920f-7c69-424a-b37e-bb638e0cb17a, Name: tapesh, Age: 35, Subjects: [java, css]
        //ID: c05c6120-4cd1-45f9-9dcb-4c44d39fcaf4, Name: Akansha, Age: 28, Subjects: [java, HTML]
        //ID: 7a654703-e42c-4eea-8884-f4d09ffb2eba, Name: Jagat, Age: 45, Subjects: [java, javascript]

        //Find student List who enroll in java course
        sms.FindStudents("java"); // krish,manshi

        // Find teacher list who teach java subject
        sms.FindTeachers("java"); // tapesh Akansha Jagat


    }
}
