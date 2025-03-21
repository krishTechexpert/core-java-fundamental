package com.StudentAppdemo.studentApp.model;

/* One To One Mapping

    we are considering each student has only one address.
*
* */
//--------------------------------------------------------------------
/*     @GeneratedValue(generator="stud_gen",strategy = GenerationType.AUTO)

* 💡 What Happens Internally? For each insert, Hibernate does two steps:

INSERT the row.

Fetch the generated ID (SELECT LAST_INSERT_ID(); in MySQL).

INSERT INTO student (student_name, department) VALUES ('Alice', 'CS');
SELECT LAST_INSERT_ID();  -- Fetch generated ID = 1

INSERT INTO student (student_name, department) VALUES ('Bob', 'Math');
SELECT LAST_INSERT_ID();  -- Fetch generated ID = 2

⏳ Performance Issue: Each insert requires an extra query to fetch the ID.


*
* */
//-------------------------------------------------------

/*
*
*  @SequenceGenerator(name="stud_gen",sequenceName = "stud_seq",initialValue = 1, allocationSize = 1)

* 💡 What Happens Internally?

Hibernate fetches 5 IDs at once (allocationSize = 5).

Uses those IDs for the next 5 inserts without querying again.
*
* SELECT NEXTVAL('stud_seq');  -- Hibernate fetches 5 IDs in one query (IDs 1-5)

* ✅ Performance Boost: Only 1 query to get IDs, then Hibernate directly inserts data!


* 🚀 Conclusion: SEQUENCE allows Hibernate to fetch multiple IDs at once,
*  reducing extra queries and improving performance.


 * */


import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(generator="stud_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="stud_gen",sequenceName = "stud_seq",initialValue = 1, allocationSize = 1)
    private Integer studentId;
    @Column(name="studentname")
    private String studentName;
    private String department;

    /*
    * Breakdown:

name = "stud_gen" → This is the name of the generator (used in @GeneratedValue).

sequenceName = "stud_seq" → This is the name of the actual database sequence.

initialValue = 1 → The first generated value will be 1.

allocationSize = 1 → Increments one step at a time.


    * */

    // save the child ref(address table data) before saving the parent reference(student table)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id") // change column name
    private Address address;// first it will save address data into address table then new student record created.

    public Student(){
        super();
        System.out.println("Student default constructor");
    }

    public Student(String studentName, String department, Address address) {
        this.studentName = studentName;
        this.department = department;
        this.address = address;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }
}
