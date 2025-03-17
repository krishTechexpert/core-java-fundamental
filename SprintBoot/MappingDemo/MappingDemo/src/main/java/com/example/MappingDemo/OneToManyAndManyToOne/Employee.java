package com.example.MappingDemo.OneToManyAndManyToOne;

/*
* 🔍 Understanding @OneToMany and @ManyToOne with Department and Employee Relationship
    In a real-world scenario, an organization has multiple departments,
     and each department has multiple employees.

    🔹 Relationship Between Department and Employee
One Department has → Many Employees (@OneToMany)

Many Employees belongs to → One Department (@ManyToOne)

    * This means:

1.) A department can have many employees (@OneToMany in Department).

2.) Each employee belongs to only one department (@ManyToOne in Employee).



*
* */


import jakarta.persistence.*;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    // Many employees belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id") // Creates a foreign key column in Employee table
    private Department dept;

}



/*
    🔸 Department    Table
        id	         name
        1           	IT
        2	            HR


*------------------------------------
* 🔸 Employee Table
id	name	position	department_id
1	John	Developer	1
2	Alice	HR Manager	2
3	Bob	    Tester	    1

* */