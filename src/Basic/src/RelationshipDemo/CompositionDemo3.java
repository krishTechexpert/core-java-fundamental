package Basic.src.RelationshipDemo;

//Composition: Bank HAS-A Account (Tightly Coupled)
/*
* 🔹 Composition (Strong HAS-A)

One class contains another, but the contained class cannot exist separately.
Example: A Car HAS-A Engine, and the Engine depends on the Car.
Used for: Strong dependency, Encapsulation.

* */
class Account {
    void accountInfo() {
        System.out.println("Account is active.");
    }
}

class SBIBank {
    private Account account;

    public SBIBank() {
        this.account = new Account(); // Strong dependency
    }

    void showAccountDetails() {
        account.accountInfo();
    }
}

public class CompositionDemo3 {
    public static void main(String[] args) {
        SBIBank bank = new SBIBank();
        bank.showAccountDetails();
    }
}
//✅ If Bank is deleted, Account is also deleted.

/*
When to Use Composition?
        ✔ When one class cannot exist without another (e.g., Car HAS-A Engine).
        ✔ When you need strong dependency between objects.
        ✔ When object encapsulation is required to hide details.
        ✔ When inheritance (IS-A) would make the system too rigid.

💡 Final Thought: Prefer Aggregation when possible to keep flexibility,
but use Composition when objects are strongly dependent on each other.




*/