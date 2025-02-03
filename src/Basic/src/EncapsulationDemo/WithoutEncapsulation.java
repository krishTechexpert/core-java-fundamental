package EncapsulationDemo;

class Employee {
    public String name;
    public int age;
}

class AnotherClass {
    public void modifyData(Employee emp){
        // Modifying the Employee object directly
        emp.name=null; //Invalid name
        emp.age=-10; //Invalid age
    }
}

public class WithoutEncapsulation {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name="krish";
        emp.age=30;

        System.out.println("Before Modification:");
        System.out.println("Name: " + emp.name);
        System.out.println("Age: " + emp.age);

        AnotherClass another = new AnotherClass();
        another.modifyData(emp); // Another class modifies the data

        System.out.println("After Modification:");
        System.out.println("Name: " + emp.name);
        System.out.println("Age: " + emp.age);

    }
}
