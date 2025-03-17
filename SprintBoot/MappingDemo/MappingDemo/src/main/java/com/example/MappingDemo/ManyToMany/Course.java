package com.example.MappingDemo.ManyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    // Many-to-Many Relationship (Bidirectional Mapping)
    @ManyToMany(mappedBy = "courses")  // `mappedBy` prevents extra join table,/ No new table, just mapped to Student
    private List<Student> students; // Many students enroll for one course

}

/* ----------- 🔹 Problem Without mappedBy ---------------

If we don’t use mappedBy,
Hibernate creates two separate join tables (one for each side of the relationship):

One table where Student references Course

Another table where Course references Student

This results in duplicate relationship tables,
leading to data inconsistency and redundancy.
 *
*----------- Example Without mappedBy---------
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
}
-------------------------
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "course_student", // ⚠️ This creates a second join table!
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();
}
-------------------------
🚨 Problem: Two Join Tables Created
| student_course Table |

student_id	course_id (First Join table)
1	            101
2	            102
-----------------------------

| course_student Table | (Second Join table)

course_id	student_id
101	            1
102	            2
This results in duplicate entries and inefficiency.
-----------------------------------------------
✅ Solution: Using mappedBy

To avoid this duplication, we use mappedBy in one of the entities.

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "courses") // No new table, just mapped to Student
    private Set<Student> students = new HashSet<>();
}
-------------------
✅ Now, Only One Join Table Exists
| student_course Table |

student_id	    course_id
1	            101
2	            102
The course_student table is NOT created anymore! 🎉
------------------------------------

🔍 Explanation of mappedBy
mappedBy = "courses" in Course tells Hibernate:
🛑 "Don't create a new join table! Just use the one in Student"

It avoids redundancy and keeps one source of truth for the relationship.

Only one join table (student_course) is created instead of two.

-------------------------------

🎯 Summary
Approach	        Issue

Without mappedBy	Creates two join tables (student_course and course_student)
With mappedBy	    Uses one join table (student_course), avoiding redundancy

Using mappedBy ensures proper bidirectional mapping and prevents duplicate join tables. 🚀

* */