package Basic.src.RelationshipDemo;

//Aggregation: Bank HAS-A Employee (Loosely Coupled)

class Employee{
    String name;
    Employee(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Employee: " + name);
    }
}

class Bank {
    private Employee employee; // Aggregation (Loose dependency)

    public Bank(Employee employee) {
        this.employee = employee; // Employee is passed externally ( means Object is passed from outside)
    }

    void showEmployee() {
        employee.show();
    }
}


public class BankAggregationDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("John"); // ✅ Employee exists independently
        Bank bank = new Bank(emp); // ✅ Employee is passed to Bank
        bank.showEmployee();
    }
}

//✅ If Bank is deleted/closed, Employee still exists.

/*❌ Why is this NOT Composition?

Employee is passed from outside, not created inside Bank constructor.
Bank does not own Employee (If Bank is destroyed, Employee still exists).
This is Aggregation, not Composition.

💡 Final Thought: Prefer Aggregation when possible to keep flexibility,
but use Composition when objects are strongly dependent on each other.


*/