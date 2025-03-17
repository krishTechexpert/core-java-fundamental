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