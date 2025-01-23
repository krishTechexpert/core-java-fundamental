package SuperDemo;

class Student {
    String name;
    String course;
    int rollNo;

    Student(String name, String course, int rollNo){
        this.name = name;
        this.course = course;
        this.rollNo = rollNo;
    }

    void print(){
        System.out.println("Student Details ;" + name + course + rollNo);
    }
}




public class SuperExample extends Student {
    int fees;
    SuperExample(String name,String course, int rollNO,int fees ){
        super(name,course,rollNO);
        this.fees = fees;
    }
    void print(){
        System.out.println("Student Details ;");
        System.out.println("name is = "+name);
        System.out.println("course is = "+course);
        System.out.println("roll number is = "+rollNo);
        System.out.println("course fees is = "+fees);
        super.print();
    }

    public static void main(String[] args) {
        SuperExample se = new SuperExample("ravi","html",1001,3000);
        se.print();

    }

}
