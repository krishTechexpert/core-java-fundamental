package Basic.src.RelationshipDemo;

//Example 2: Human and Heart (Composition)
//A Human HAS-A Heart, and a Heart cannot exist independently.
//A Human HAS-A Heart, meaning Human is the container class, and Heart is the contained object.

class Heart {
    void pump() {
        System.out.println("Heart is pumping...");
    }
}

class Human {
    private Heart heart; // Composition

    public Human() {
        this.heart = new Heart(); // Human creates its own Heart
    }

    void live() {
        heart.pump();
        System.out.println("Human is alive...");
    }
}

public class CompositionDemo2 {
    public static void main(String[] args) {
        Human human = new Human();
        human.live();
    }
}

/*
* ✅ Explanation:

Human (Container Class) → It contains an instance of Heart.
Heart (Contained Object) → It is created inside Human Constructor and cannot exist separately.
If Human is deleted, Heart is also deleted.

* */

//Output
//Heart is pumping...
//Human is alive...
/*
* 🔍 Why is This Composition?
Human owns Heart.
Heart cannot exist without Human.
If Human is deleted, Heart is also deleted.

*
* 💡 Final Thought: Prefer Aggregation when possible to keep flexibility,
* but use Composition when objects are strongly dependent on each other.


*
* */