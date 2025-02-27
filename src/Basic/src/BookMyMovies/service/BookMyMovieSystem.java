package Basic.src.BookMyMovies.service;

import Basic.src.BookMyMovies.config.DataBaseConfig;

import java.sql.*;
import java.util.List;
/* Book my show project
My approach will be:
1️⃣ User enters a city
2️⃣ Show all movies available in that city
3️⃣ User selects a movie
4️⃣ Show all theaters in that city where the selected movie is running
5️⃣ User selects a theater
6️⃣ Show available shows for the selected movie in that theater
7️⃣ User selects a show and seats
8️⃣ Booking is processed


* 💡 Summary
1️⃣ User enters city → Mumbai
2️⃣ Show movies in that city
3️⃣ User selects movie → Pathaan
4️⃣ Show theaters playing Pathaan
5️⃣ User selects theater → PVR Cinemas
6️⃣ Show available shows
7️⃣ User selects show & seats
8️⃣ Booking is processed successfully 🎉

*
* */

public class BookMyMovieSystem {

    public void displayMoviesInCity(String city){
        Connection con=null;
        try{
            con = DataBaseConfig.getConnection();
            //to describe query with example
            //1. find Theater IDs in Mumbai
            //2. find Movies Ids in Mumbai
            //3 show all movies Available in the mumbai such as title,genre,Id
            //Note: Your SQL query execution order follows a nested execution approach,
            // meaning the innermost subquery executes first, then the outer queries.
            PreparedStatement ps=con.prepareStatement("select movie_id,title,genre from movies where movie_id IN (select movie_id from shows where theater_id IN (select theater_id from theaters where city=?))");
            ps.setString(1,city);
            ResultSet rs = ps.executeQuery();
            System.out.println("Movies available in " + city + ":");
            while(rs.next()){
                System.out.println(rs.getInt("movie_id")
                                    +". "+rs.getString("title")
                                    +" ("+rs.getString("genre")+")"
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            closeConnection(con);
        }
    }

    public void displayTheatersForMovie(int movieId,String city){
        Connection con=null;
        try{
            con = DataBaseConfig.getConnection();
            //to describe query with example
            //select moviesId=1 chava and  city delhi
            //3 threater in delhi  PVR(1),Spice(6),Irox(7)
            //theaterId 1(delhi),2(agra),3(mumbai)
            //chava running in 2 theater in delhi such as PVR,Spice
            //finally got PVR Threater
            PreparedStatement ps=con.prepareStatement("select theater_id, name from theaters where city=? AND theater_id IN (select theater_id from shows where movie_id=?)");
            ps.setString(1,city);
            ps.setInt(2,movieId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Theaters playing selected movie:");
            while(rs.next()){
                System.out.println(rs.getInt("theater_id")
                        +". "+rs.getString("name")

                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            closeConnection(con);
        }
    }

    public void displayAvailableShows(int movieId,int theaterId){
        Connection con=null;
        try{
            con = DataBaseConfig.getConnection();
            //to describe query with example
            //Chava movie show running
            //PVR: 10:00 AM
            //Spice: 1:00 PM
            PreparedStatement ps=con.prepareStatement("select show_id, timing, available_seat from shows where movie_id=? AND theater_id=?");
            ps.setInt(1,movieId);
            ps.setInt(2,theaterId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Shows:");
            while(rs.next()){
                System.out.println(rs.getInt("show_id")
                        + ". " + rs.getString("timing")
                        + " - Seats Available: " + rs.getInt("available_seat"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            closeConnection(con);
        }
    }
    //Book ticket
    /*🚀 Key Takeaway
    Use COMMIT when you are sure the transaction is correct.
    Saves all changes made during the transaction permanently.

    Use ROLLBACK to cancel changes if something goes wrong.
    Reverts all changes made during the transaction.

    */
    public void bookTicket(int userId, int showId, String[] seats) {
        Connection con=null;
        try{
            con = DataBaseConfig.getConnection();
            con.setAutoCommit(false);
            /*
            By default, database connections in Java run in auto-commit mode (autoCommit=true).
            Each SQL statement is executed and committed automatically.
            No need to call commit() manually.
            However, when we disable auto-commit (autoCommit=false), we take control of when transactions are committed.

            * disables auto-commit mode, meaning changes to the database won’t be saved automatically.
            *  Instead, you must explicitly call con.commit(); to save the changes or con.rollback();
            *  to undo them.
             * */
            boolean alreadyBookedSeat = false;
            //first we will check selected seat is available or not
            for(String seat:seats){
                PreparedStatement ps =  con.prepareStatement("select * from seat where show_id =? AND seat_number =?");
                ps.setInt(1,showId);
                ps.setString(2,seat.trim());
                ResultSet rs = ps.executeQuery();
                if(rs.next() && rs.getBoolean("is_booked")){
                    alreadyBookedSeat = true;
                    System.out.println("Seat " + seat + " is already booked. Choose another seat.");
                }
            }
            //suppose user enter A1,A3 seat then we checked that A1 is already booked and A3 is now availale
            //if user want to book both seat together but only 1 seat is available, then we will not allowed to book ticket
            if(alreadyBookedSeat) {
                System.out.println("Booking Failed! Some seats are already booked.");
                con.rollback();//revert all changes and don't save ito DB
                return;
            }
            // now we are sure here that both seat are available.then we can processed further to book seat
            for (String seat : seats) {
                PreparedStatement ps = con.prepareStatement("UPDATE seat SET is_booked = true WHERE show_id = ? AND seat_number = ?");
                ps.setInt(1, showId);
                ps.setString(2, seat.trim());
                ps.executeUpdate();
            }
            double seatPrice=200.0;
            double totalAmount = seats.length * seatPrice;
            //now insert data in Bookings table finally
            PreparedStatement ps = con.prepareStatement("INSERT INTO bookings(user_id, show_id, seats_booked, total_price) VALUES (?, ?, ?, ?)");
            ps.setInt(1, userId);
            ps.setInt(2, showId);
            ps.setString(3, String.join(",", seats));
            ps.setDouble(4, totalAmount);
            ps.executeUpdate();
            // also update available_seat in shows table when booking confirmed
            PreparedStatement psUpdate = con.prepareStatement("UPDATE shows SET available_seat = available_seat - ? WHERE show_id = ?");
            psUpdate.setInt(1, seats.length);
            psUpdate.setInt(2, showId);
            psUpdate.executeUpdate();
            con.commit();//finally we are saving data in DB..here we are sure now
            System.out.println("Booking Successful! Seats: " + String.join(",", seats) + " | Total Price: ₹" + totalAmount);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            closeConnection(con);
        }

    }

        private void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
