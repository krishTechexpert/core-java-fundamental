package com.krish.JPAFirstDemoApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

// this getter ,setter,constructor,toString etc created by lombook plugin we already updated in pom.xml
// or you can used single lombook annotation such as @Data will genertate all of this getter,setter etc.

@Getter
@Setter
@NoArgsConstructor // it(default constructor) is must JPA need it otherwise it will give error
@AllArgsConstructor
@ToString

@Entity //Marks the class as a JPA entity (table in DB). and it is must
@Table(name = "employees") // in db there is an already table employees, but java table name is Employee

//IMP Notes
// suppose employees table is already present in db but we are using different table name in java class as Employee we have to used @Table
//if there was no already present table employees in db then it will create for us table like employees

public class Employee {
    @Id //make primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id will increase by one
    private int id;

    @Column(name="empName") // empName is column name in DB but we used in java class code as name which represent same as empName
    //empName--> represent with camelcase such as emp_Name in DB

    private String name;

    private double salary;
    private String dep;

    // if lombok not work then you need to create manual getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}


/* types of GeneratedValue :
Table: we need make table for primary increment
SEQUENCE: we need sequence to increase primary key
IDENTITY: MYSQL will auto increment
UUID:
AUTO: my sql will automatically select best one for you
*/