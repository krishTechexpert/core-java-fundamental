package com.example.MappingDemo.ManyToMany;

//-------- Many-to-Many relationship mapping--------------

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**📌 Real-Life Analogy: Students and Courses
Imagine we have Students and Courses:

A student can enroll in multiple courses. such as Max enrolls java,php,DB,HTML course

A course can have multiple students. such as suppose Instructor want to check
 hey how many student enroll in my three course
    i.) DB course enroll---100 students
    ii.) php course enroll --20 students
    iii.) html course enroll --40 students

Since both Student and Course entities can have a many-to-many relationship,
 we need a join table to map them.
 it means we create new table which will contains two columns:
    1.) student_id
    2.) course_id

 A student can enroll in multiple courses, and a course can have multiple students.

 */

/*
* ✅ Steps for Many-to-Many Mapping
Create Student Entity

Create Course Entity

Use @ManyToMany with @JoinTable to create a join table (student_course)//name of join table

Hibernate will automatically generate the join table(student_course)

Test the relationship by adding data


* */

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // Many-to-Many Relationship
    @ManyToMany
    @JoinTable(
            name="student_course", // name of new Join Table
            joinColumns = @JoinColumn(name="student_id"), // FK of Student, first column
            inverseJoinColumns = @JoinColumn(name="course_id") // FK of Course, second column
    )

    private List<Course> courses;  // Many courses for one student


    //joinColumns: Specifies the foreign key column for the current entity
                    // (the one defining the @ManyToMany relationship).

    //inverseJoinColumns: Specifies the foreign key column for the other entity in
                            // the relationship.



}


/*
* Step 3: Database Schema Generated by Hibernate
*
  Student Table:
    id (PK)	            name
     1              	Alice
     2	                Bob
-----------------------------------------
*
* course Table:
*   id (PK)	            title
    101	                Java
    102	                Spring Boot
-----------------------------------------
*
*
 student_course: (Join Table)

*   student_id (FK)	    course_id (FK)
        1	                101
        1	                102
        2	                101
--------------------------------------
*
* */