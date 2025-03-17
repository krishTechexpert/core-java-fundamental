package com.example.MappingDemo.OneToOne;

import jakarta.persistence.*;

/*
* one to one mapping @OneToOne
* when you create an account on flipkart,
* then your profile has created which belong to you only
* 1 student has 1 profile
* 1 profile belong to only 1 student
*
* another example: 1 country- has -1 prime minster
*
* Think about a Person and their Passport:

Each Person has only one Passport.

Each Passport belongs to only one Person.

In a database, we model this using a One-to-One relationship.


*
* */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL) //
    //suppose you are updating some date in student and profie.
    // but there is some failure in profile at the time of storing value,
    // then profile and student data will be deleted , not saved
    // means update ho toh dono table m hoga and delete hoga toh dono table s hoga
    // just like rollback and commit kerta


    //student can connect with profile, like same as  foreign key
    @JoinColumn(name="profile_id", referencedColumnName = "id")
    //This creates a foreign key (profile_id) in the student table.
    private Profile profile;

    /*
    * ✅ 1. Use Optional<Profile> in Student Class
    Why? Helps to avoid NullPointerException when accessing profile if it is null.
    private Optional<Profile> profile;


    * */

}
