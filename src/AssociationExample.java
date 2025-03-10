//-------- What is Association?-----------

/*
https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/association
* Association defines a connection between two classes, where one class is linked to another.
* The association can be one-to-one, one-to-many, many-to-one, or many-to-many.
* Objects in an association can exist independently of each other.
*
* Key Characteristics of Association:
    Represents a uses-a or knows-a relationship.
    Objects in an association can exist independently.
    Can be unidirectional or bidirectional.
    Promotes modularity and code reusability.

*
* */


/*
* Types of Association

* 1. One-to-One Association
Each object of class A is associated with one object of class B.
Example: A Person has one Passport/one pancard., A country have one PM

* 2. One-to-Many Association
One object of class A can be associated with multiple objects of class B.
Example: A Teacher teaches multiple Students., PM instruct to all CM, A cricketer play with many teams

* 3. Many-to-One Association
Multiple objects of class A can be associated with one object of class B.
Example: Multiple Students belong to one School., all CM/PM comes into Sadn and speak infront of Loksabha speaker
multiple account(FB,insta,twiter belongs to one user(with same id)
*
* 4. Many-to-Many Association
Multiple objects of class A can be associated with multiple objects of class B.
Example: Teachers and Students (a student can have multiple teachers, and a teacher can have multiple students).

* 📌 Real-World Example:
A student can enroll in multiple courses.
A course can have multiple students.
Student has a List<Course>, meaning a student can enroll in multiple courses.
Course has a List<Student>, meaning a course can have multiple students.

*
* */

// Associations can be unidirectional (one object knows about another but not vice versa) or
// bidirectional (both objects know about each other).


import java.util.*;

class STUdent {
    private String name;
    private List<Course> courses; // A student can enroll in multiple courses

    public STUdent(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enroll(Course course) {
        courses.add(course);
        course.addStudent(this); // Maintain bidirectional(both objects know about each other). relationship
    }

    public void showCourses() {
        System.out.print(name + " is enrolled in: ");
        for (Course course : courses) {
            System.out.print(course.getCourseName() + " ");
        }
        System.out.println();
    }
}

class Course {
    private String courseName;
    private List<STUdent> students; // A course can have multiple students

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(STUdent student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        STUdent s1 = new STUdent("Alice");
        STUdent s2 = new STUdent("Bob");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        // Enrolling students in courses
        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);

        // Show enrolled courses
        s1.showCourses(); // Alice is enrolled in: Math Science
        s2.showCourses(); // Bob is enrolled in: Math
    }
}

