package Basic.src.JDBCBasic;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//jdbc-->hibernate-->jpa
public class InsertStudent {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/students_db";
        String username="root";
        String password = "Kiwtech@123";

        // insert static query b'coz we are passing hard coded values
        // String query = insert into student (name,age,course) values('krish',30,'DSA');

        // introduced Prepared Statement for dymanic query
        //we will used prepared Statement to create dynamic insert/update/delete query
        String query ="Insert into student (name,age,course) values (?,?,?)";//called dynamic query
        //en ? mark ko runtime per prepeared statement resolved kerta hai

        Connection con =null;
        try{
            con =  DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = con.prepareStatement(query);
            //1 ? marke show name column in DB denote by 1
            //2 ? marke show age column in DB denote by 2
            //3 ? marke show course column in DB denote by 3 and so on...

            //1 record
            pstmt.setString(1,"prem");
            pstmt.setInt(2,25);
            pstmt.setString(3,"DSA");
            pstmt.executeUpdate();

            //2 record
            pstmt.setString(1,"rashmi");
            pstmt.setInt(2,21);
            pstmt.setString(3,"html");
            pstmt.executeUpdate();

            System.out.println("insert data successfully...");
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally{
            con.close();
        }
    }
}
