package com.example.MappingDemo.OneToOne;

import com.example.MappingDemo.Student;
import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // now profile can connect with student

    @OneToOne(mappedBy = "profile") //// No extra FK in Profile table
    //✅ Benefit: Now, only Student holds the foreign key (profile_id).
    // Hibernate does not create an extra column in Profile. that will hold student_id
    //  it is considered a best practice for bidirectional relationships.
    private Student student;
}

/*
* 💡 Conclusion
@OneToOne(mappedBy = "profile") is not required,
* but it prevents redundant foreign keys and ensures clean schema design.

If you don't use mappedBy,
* Hibernate will add an extra column in the Profile table, which is unnecessary.
This is redundant because a One-to-One relationship needs only one foreign key.


👉 Best Practice? ✅ Always use mappedBy for bidirectional One-to-One relationships.
🚀 Use mappedBy = "profile" in Profile to prevent unnecessary foreign keys in the database.

*
* */


/*
🎯 Key Takeaways

Scenario	          Foreign Keys Created	                            Best Practice?

❌ Without mappedBy	  passport_id (in Person) + person_id (in Passport)	    ❌ No

✅ With mappedBy	        passport_id (in Person only)	                    ✅ Yes

👉 Always use mappedBy in One-to-One bidirectional relationships to prevent extra columns in the database.

*/


/*------------ IMP Points -------------

If you want to ensure that when a Profile is deleted, the associated Student should also be deleted, then you need to handle this explicitly.

Key Points:
By default, the foreign key is stored in the Student table (profile_id column).

Since Student is the owner of the relationship (@JoinColumn is in Student), deleting Profile alone will not automatically remove the reference from Student.

Solution: Use orphanRemoval = true or manually delete the Student when deleting Profile.
------------------------------------
✅ Solution 1: Use orphanRemoval = true
Hibernate provides orphan removal, which means if the child entity (Profile) is removed, the parent (Student) will be updated to remove the reference.

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // ✅ Ensures FK removal in Student when Profile is deleted
    @JoinColumn(name="profile_id", referencedColumnName = "id")
    private Profile profile;
}

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "profile")
    private Student student;
}

How orphanRemoval = true Works?
If you remove the Profile from Student,
the profile_id foreign key will be removed from the Student table automatically.

But it does not delete the Student itself—only the reference
(profile_id is set to NULL in the Student table).
---------------------------------------------------

✅ Solution 2: Manually Delete the Student When Profile is Deleted
If you want to delete the Student when the Profile is deleted,
you need to manually handle it.



 */