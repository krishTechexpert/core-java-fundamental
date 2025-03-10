/*
* https://github.com/ashishps1/awesome-low-level-design/tree/main/oop/java/association
*
* ----------- Bidirectional Association -----------
*
* Associations can be unidirectional (one object knows about another) or
* bidirectional (both objects know about each other).

* //Example: A Library and Books (Bidirectional Association)
*
* In this code, bidirectional association means that:

A Library knows about its Books (through List<Book> books).
A Book knows about its Library (through private Library library).

 * */

import java.util.*;

class Book {
    private String title;
    private Library library;

    public Book(String title, Library library) {
        this.title = title;
        this.library = library;
        library.addBook(this); // 🔹 Automatically add this book to the library

    }

    public void showLibrary() {
        System.out.println(title + " is in " + library.getName());
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            System.out.println(" - " + book.getTitle());
        }
    }
}

public class BidirectionalAssociation {
    public static void main(String[] args) {
        Library library = new Library("City Library");
        Book book1 = new Book("1984", library);
        Book book2 = new Book("Brave New World", library);

        // Add books to the Library (Library knows the Books)
        //library.addBook(book1);
        //library.addBook(book2);
        // we comment this line because we are adding inside book constructor


        library.showBooks(); // Shows books in the library

        book1.showLibrary(); // Shows which library owns this book
        book2.showLibrary();


    }
}
