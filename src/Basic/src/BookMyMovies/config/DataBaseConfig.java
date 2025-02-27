package Basic.src.BookMyMovies.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    private static final String  url="jdbc:mysql://localhost:3306/Bookmymovies"; //Bookmymovies is dbname and
    //try to make DB name is in lowercase next time
    private static final String username="root";
    private static final String password="Kiwtech@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}


/*
* Database sql query
*
* create database Bookmymovies;
use Bookmymovies;

create table users (
user_id int primary key auto_increment,
name varchar(30),
email varchar(30),
phone varchar(30)
);

create table movies(
movie_id int primary key auto_increment,
title varchar(30),
genre varchar(30),
lang varchar(30),
duration int(30)
);

create table theaters(
theater_id int primary key auto_increment,
name varchar(30),
city varchar(30)
);

create table shows(
show_id int primary key auto_increment,
movie_id int,
theater_id int,
timing varchar(30),
available_seat int,
foreign key (movie_id) references movies(movie_id),
foreign key (theater_id) references theaters(theater_id)
);

create table seat (
seat_id int primary key auto_increment,
show_id int,
seat_number varchar(10),
is_booked boolean default false,
foreign key (show_id) references shows(show_id)
);

create table bookings(
booking_id int primary key auto_increment,
user_id int,
show_id int,
seats_booked varchar(30),
total_price decimal(10,2)
);

insert into users (name,email,phone) values
('krish','krish@gmail.com','9898989898'),
('seema','seema@gmail.com','9292929280'),
('max','max@gmail.com','7788675421');

insert into movies(title,genre,lang,duration) values
('Chhava','history','hindi',148),
('ironman','action','english',150),
('puspa','thriller','telugu',180),
('orphan','horror','english',120);

insert into theaters(name,city) values
('PVR','Delhi'),
('INOX','Agra'),
('Cinepolis','Mumbai'),
('IMAX','Pune'),
('Meeraj','Nasik');


insert into shows (movie_id,theater_id,timing,available_seat) values
(1,1,'10:00 AM',40),
(1,2,'3:00 PM',50),
(2,3,'7:00 PM',60),
(3,4,'9:00 PM',30),
(4,5,'9:00 AM',30),
(2,3,'4:00 PM',60);


insert into seat(show_id,seat_number,is_booked) values
(1,'A1',FALSE),(1,'A2',FALSE),(1,'A3',FALSE),(1,'A4',FALSE),(1,'A5',FALSE),
(2,'B1',FALSE),(2,'B2',FALSE),(2,'B3',FALSE),(2,'B4',FALSE),(2,'B5',FALSE),
(3,'C1',FALSE),(3,'C2',FALSE),(3,'C3',FALSE),(3,'C4',FALSE),(3,'C5',FALSE),
(4,'D1',FALSE),(4,'D2',FALSE),(4,'D3',FALSE),(4,'D4',FALSE),(4,'D5',FALSE),
(5,'E1',FALSE),(5,'E2',FALSE),(5,'E3',FALSE),(5,'E4',FALSE),(5,'E5',FALSE);

insert into bookings(user_id,show_id,seats_booked,total_price) values
(1,1,'A1,A2',400);

update seat set is_booked=true where show_id=1 and seat_number In('A1','A2');

select * from seat;//you will A1,A2 is updated in seat Table

* */