package Basic.src.JDBCBasic;

import javax.naming.directory.DirContext;
import java.sql.*;
//jdbc-->hibernate-->jpa //now jpa is in using in IT industry
public class FetchStudent {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/students_db";
        String username="root";
        String password="Kiwtech@123";

        String query = "select * from student";//static query
        Connection con =null;
        try{
            //1. driver load kro (step 1 is optional)
            /*download mysql-connector-java-8.0.28.jar
            right click on project and select open module setting
            select library and click on + icon then select java and select jar file location
             apply  and ok
             after you can see under External libraries mysql-connector-java-8.0.28.jar(yhi driver jdbc ki implementataion deta hai)

             Note: Internally Driver ek class hai jo ki load kerna padta hai jis vendor ka DB used ker rehy ho
             */

            //Class.forName("com.mysql.cj.jdbc.Driver");//after jdbc4 and java1.8, no need to load manually driver , it will detect automatically after loading mysql-connector jar file
            //2. connection establish
            con = DriverManager.getConnection(url,username,password);
            //3. create statement
            // statement , sql static query  ko execute kerny k kaam ata hai
            Statement stmt = con.createStatement();
            //4. execute above statement
            //Returns: a ResultSet object that contains the data produced by the given query; never null
            ResultSet rs = stmt.executeQuery(query);
            //eski implementation dekni ho toh StatementImpl.class on line 884 and find
            // synchronized(this.checkClosed().getConnectionMutex()) {
            //5. get Results
            System.out.println("Id | Name | Age | Course");
            System.out.println("-------------------------");

            while(rs.next()){
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("age") + " | " +
                        rs.getString("course")
                        );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            con.close();
        }
    }
}
