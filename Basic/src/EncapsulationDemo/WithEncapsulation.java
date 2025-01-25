package EncapsulationDemo;

class Employe{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if(name !=null && !name.isEmpty()){
           this.name = name;
       }else {
           System.out.println("Invalid Name");
       }
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
       if(age>0) {
           this.age=age;
       }else {
           System.out.println("Invalid age");
       }
    }

}

public class WithEncapsulation {
    public static void main(String[] args) {
        Employe emp = new Employe();
        // Only valid data can be set
        emp.setName("John Doe");
        emp.setAge(30);

        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());

        // Attempt to set invalid data
        emp.setAge(-10); // Validation prevents this
        emp.setName(""); // Validation prevents this

    }
}
