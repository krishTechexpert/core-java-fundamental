package Basic.src.JDBCBasic;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//jdbc-->hibernate-->jpa
public class UpdateStudent {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/students_db";
        String username="root";
        String password = "Kiwtech@123";

        String query ="update student set name=? , course=?  where id=? ";//called dynamic query

        Connection con =null;
        try{
            con =  DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,"Maxx");
            pstmt.setString(2,"Java");
            pstmt.setInt(3,4);
            int updateStudent = pstmt.executeUpdate();
            if(updateStudent>0) {
                System.out.println("update data successfully...");
            }else {
                System.out.println("data not found");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally{
            con.close();
        }
    }
}
