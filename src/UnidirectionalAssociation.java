/*
*
* // Associations can be unidirectional (one object knows about another but not vice versa) or
// bidirectional (both objects know about each other).

*   -----------Unidirectional Association in Java-----------
A unidirectional association means that one object knows about the other, but not vice versa.

✅ Example: A Country and a President

A Country knows about its President.
But the President does not know about the Country.
*
* ✅ Why is this Unidirectional?

Country knows about President.
President does not store any reference to Country.

*
* */

class President {
    private String name;

    public President(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Country {
    private String name;
    private President president; // Unidirectional: Country → President

    public Country(String name, President president) {
        this.name = name;
        this.president = president;
    }

    public void showPresident() {
        System.out.println("The president of " + name + " is " + president.getName());
    }
}


public class UnidirectionalAssociation {
    public static void main(String[] args) {
        President p1 = new President("John Doe");
        Country c1 = new Country("Wonderland", p1);

        c1.showPresident(); // The president of Wonderland is John Doe

    }
}
