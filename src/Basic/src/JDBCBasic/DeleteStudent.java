package Basic.src.JDBCBasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/students_db";
        String username="root";
        String password = "Kiwtech@123";

        String query = "delete from student where id=?";
        //jdbc-->hibernate-->jpa
        Connection con=null;
        try{
            con =  DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,12);//here 1 represent id column denote by 1
            int deleteRecord = pstmt.executeUpdate();
            if(deleteRecord>0) {
                System.out.println("delete data successfully...");
            }else {
                System.out.println("data not found");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            con.close();
        }
    }
}
