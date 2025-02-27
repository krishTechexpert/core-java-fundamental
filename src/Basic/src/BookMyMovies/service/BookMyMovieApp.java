package Basic.src.BookMyMovies.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* In Java, when you take input using Scanner, some methods leave a hidden \n (newline character)
* in the input buffer.
If we don’t "consume" (remove) this \n, it can cause issues in future inputs.

* 🚀 Important Issue: nextInt() + nextLine()

* nextInt() only reads the number and leaves \n (Enter) in the buffer.

✅ Solution: Add sc.nextLine() After nextInt()

* To Analyze data
* ('Chhava','history','hindi',148),#1 this are movies Id
('ironman','action','english',150),#2
('puspa','thriller','telugu',180),#3
('orphan','horror','english',120),#4
('Jawan','action','hindi',120),#9
('Pathaan','Thriller','hindi',150),#10
('Avatar2','Sci-Fi','english',180);#11


//1,2,3 are Ids
('PVR','Delhi'),#1
('INOX','Agra'),#2
('Cinepolis','Mumbai'),#3
('IMAX','Pune'),#4
('Meeraj','Nasik'),#5
('Spice','Delhi'),#6
('Irox','Delhi'),#7
('Apsara','Mumbai');#8


(1,1,'10:00 AM',40),#Chhava,delhi,PVR
(1,2,'3:00 PM',50),#Chhava,agra,INOX
(2,3,'7:00 PM',60),#ironman,Mumbai,Cinepolis
(3,4,'9:00 PM',30),#puspa,Pune,Imax
(4,5,'9:00 AM',30),#orphan,Nasik,Meeraj

(9,1,'11:00 AM',30),#jawan,delhi,PVR
(10,3,'9:00 PM',20),#Pathaan,Mumbai,Cinepolis
(11,1,'11:00 PM',20), #Avatar2,delhi,PVR
(1,3,'8:00 AM',10),#Chhava,Mumbai,Cinepolis
(10,1,'11:00 PM',15); #Pathaan,delhi,PVR
(1,6,'1:00 PM',40);#Chhava,delhi,Spice
(1,1,'12:00 PM',50);#Chhava,delhi,PVR
*
*
* */


public class BookMyMovieApp {
    public static void main(String[] args) {
        BookMyMovieSystem app =new BookMyMovieSystem();
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter City Name");
        String city = sc.next();//Read only first word
        //It does not read the entire line, only the first word (until whitespace).
        app.displayMoviesInCity(city);

        // 📌 Next Step : User Selects a Movie
        //Show Theaters in That City Playing the Selected Movie
        System.out.println("Enter Movie Id:");
       // int theaterId = sc.nextInt();//Reads only the integer
        int movieId = sc.nextInt(); // Reads number, but leaves `\n` in the buffer
        app.displayTheatersForMovie(movieId,city);

       // 📌 Next Step : User Selects a Theater
       // Show Available Shows for the Selected Movie in That Theater
        System.out.println("Enter Theater ID: ");
        int theaterId =sc.nextInt();
        app.displayAvailableShows(movieId,theaterId);

        //📌 Next Step : User Selects a Show and Seats
        System.out.println("Enter Show Id: ");
        int showId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Seat Numbers (comma-separated): ");
        String[] seats = sc.nextLine().split(",");

        app.bookTicket(1, showId, seats);

         // sc.nextLine()
        // 👉 Reads the entire line of input, including spaces, until Enter (\n) is pressed.
        //When you need to read multiple words or full sentences (e.g., names, addresses, descriptions).
    }
}
