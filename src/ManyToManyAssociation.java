/*
* Example: A Student and a Teacher
A Student can be associated with multiple Teacher objects,
* and a Teacher can have multiple Student objects.
* This represents a many-to-many association.
*
* */

import java.util.*;

class Teacher {
    private String name;
    private List<STudent> students;

    public Teacher(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(STudent student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println(name + " teaches:");
        for (STudent student : students) {
            System.out.println(" - " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class STudent {
    private String name;

    public STudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public class ManyToManyAssociation {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Mr. Smith");
        Teacher teacher2 = new Teacher("Mrs. Johnson");

        STudent student1 = new STudent("Alice");
        STudent student2 = new STudent("Bob");

        teacher1.addStudent(student1);
        teacher1.addStudent(student2);

        teacher2.addStudent(student2);

        teacher1.showStudents();
        teacher2.showStudents();

    }
}
//Bob 2 teacher(smth,johnson) s padta hai
// smith 2 student ko pada ty hai