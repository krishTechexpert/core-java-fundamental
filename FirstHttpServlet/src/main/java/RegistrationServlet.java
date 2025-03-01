//1.manual process by adding servlet jar file
/*step1: right click on FirstHttpServlet and select open module settings
* step2: select libraries then click on '+' icon and select java
* step 3: select location where you download servlet-api.jar file and apply and ok.
*

* ✅ Alternative: Add servlet-api.jar Manually (Without Maven)
If you're not using Maven, manually download the JAR:
🔗 Download jakarta.servlet-api-6.0.0.jar

Then, add it to IntelliJ IDEA:

Right-click your project → Open Module Settings
Go to Libraries → Click + → Java
Select the downloaded jakarta.servlet-api-6.0.0.jar
Click Apply → OK

* *
 HttpServlet work well only if then you will add  servlet-api.jar file, jiky ander servlet ki implementaion padi hai
if we don't add this jar file then our java code does not understand HttpServlet
* (because servlet ka code tomcat provide krat hai so It is required to add jar file)
* */

// 2nd way using Maven(build automation tool), if you don't want to add servlet-api.jar file manually then you
//can put dependency inside pom.xml file which is recommend approach (just like package.json we do)
// you can find all dependency on maven respository just like npm repository
//https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1
/* if you add successfull dependency in pom.xml such as
    <!-- for tomcat 9 or below https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>

    🔹 If you're using Tomcat 9 or below, use javax.servlet-api instead of jakarta.servlet-api.

        <!-- Jakarta Servlet API (for Tomcat 10 and 11) -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>
     you can check inside External Libraries -> Maven: jakarta.servlet:jakarta.servlet-api:6.0.0
    enjoy code
*/

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class RegistrationServlet extends HttpServlet {
    List<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();
        out.println("<h2>User Registration</h2>");
        if(users.isEmpty()){
            out.println("<p>No User Registered!</p>");
        }
        else {
            out.println("<ul>");
            for(User user:users){
                out.println("<li>"+user.getName()+" - "+user.getEmail()+"</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='index.html'>Back to registration page</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        users.add(new User(name,email));

        resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();
        out.println("<h2>Registration Successful</h2>");
        out.println("<p>Name: "+name +"</p>");
        out.println("<p>email: "+email +"</p>");
        out.println("<a href='register'>View all users</a>");
        out.println("<a href='index.html'>Registered New User!</a>");

    }
}


class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}