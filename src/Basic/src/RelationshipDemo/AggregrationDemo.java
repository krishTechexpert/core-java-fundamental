package Basic.src.RelationshipDemo;

/*
* What is Aggregation (Weak HAS-A)?
Aggregation is a HAS-A relationship in Java, where one class contains an object of another class,
* but both can exist independently.

* class A has-a relationship with class B, if class A has a reference to an instance of class B
* class Address {}
* class Student{
* private Address adres;// Aggregation (HAS-A Relationship)
* }
* student k pass address ho bi sekta hai or nhi bi ho sekta hai, agar student move in new city , may be chance student k pass address nhi ho
* but address k liye zarori hai student ka hona ,it shows one way relationship
*
*
🔹 Key Points:

Weak Association – The contained object can exist without the container.
Parent and Child have separate lifecycles.
Used for code reusability and flexibility.
*
* Why Do We Need Aggregation?
Reduces Code Duplication – Common objects are reused instead of being created multiple times.
Improves Maintainability – Changes in one class don’t affect the other class directly.
More Flexible than Inheritance (IS-A) – No strict dependency between classes.

How to Implement Aggregation in Java?
Aggregation is implemented by using instance variables that store references to other objects.
class Bank {
    private Employee employee; // ✅ Step 1: Declare an instance variable

    public Bank(Employee employee) { // ✅ Step 2: Pass object as a parameter
        this.employee = employee;
    }
}
*         Employee emp = new Employee("John"); // ✅ Employee exists independently
        Bank bank = new Bank(emp); // ✅ Passing Employee to Bank (Aggregation)

* */
//Example 1: Aggregation in a Student and Address Relationship
//A Student HAS-A Address, but both can exist independently.

class Address {
    String city, state, country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

class Student {
    int id;
    String name;
    Address address; // Aggregation (HAS-A Relationship)

    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(id + " " + name);
        System.out.println(address.city + ", " + address.state + ", " + address.country);
    }
}

public class AggregrationDemo {
    public static void main(String[] args) {
        Address addr1 = new Address("New York", "NY", "USA");
        Student s1 = new Student(101, "John", addr1);
        s1.display(); // Student HAS-A Address

    }
}
//Output
//101 John
//New York, NY, USA

/*Why is This Aggregation?
Address is a separate class, and Student contains a reference to it.
The Address object can exist without a Student.
The Student HAS-A Address, but they are loosely coupled.
*/


/*
* Conclusion
🔹 Aggregation (Weak HAS-A)

One class contains another, but both can exist independently.
Example: A Student HAS-A Address, but Address can exist without Student.
Used for: Reusability, Loose Coupling.

* 💡 Final Thought: Prefer Aggregation when possible to keep flexibility,
* but use Composition when objects are strongly dependent on each other.



* */