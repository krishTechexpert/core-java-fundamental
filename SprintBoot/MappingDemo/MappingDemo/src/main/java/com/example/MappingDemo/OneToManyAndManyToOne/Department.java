package com.example.MappingDemo.OneToManyAndManyToOne;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;


import java.util.List;

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // One department has many employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

}

/*
*
* @OneToMany(mappedBy = "department") in Department
Defines that one department can have multiple employees.

The mappedBy = "department" ensures that the Department table does not get a foreign key column.

The foreign key is only stored in the Employee table.
*
* When you use mappedBy = "department",
* Hibernate does not create a separate join table.
* Instead, it adds a department_id column in the Employee table,
* which is the correct approach for a One-to-Many relationship.
* */


/*
* 🎯 Summary
Case	Effect
❌ Without mappedBy	Hibernate creates an extra join table (not needed in One-to-Many).

* ✅ With mappedBy	No extra table, and department_id is directly stored in Employee table.
So, mappedBy = "department" ensures that the Department table does not have a
* foreign key column and instead the foreign key (department_id) is stored
* in the Employee table, which is the correct approach! 🚀

*
* */

//------------------------------------------------

/*
* 1️⃣ What Happens Without Cascade?
If we do not use cascade = CascadeType.ALL, we need to manually save and delete
* employees when performing operations on the department.

* 2️⃣ What Happens With cascade = CascadeType.ALL?
By adding cascade = CascadeType.ALL, any operation on Department will also apply
* to its associated Employees.

✅ Now, Hibernate Handles Everything Automatically

* Delete Scenario:
departmentRepo.deleteById(1L); // ✅ Deletes the department and all related employees

    * Without Cascade: Employees would remain in the database.

    With Cascade: Employees linked to the department will be deleted automatically.

    It ensures child records (employees) are deleted when the parent (department) is deleted.

*
* */