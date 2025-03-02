/*
* --------Spring Core(SC) ---------
* In Spring Core, it is all about managing dependencies among the classes with loosely coupling
*
* In project, We will develop several classes , and all those classes are categorized into 3 ways
* 1. POJO(Plain Old Java Object)
* 2. Java Bean
* 3. Component
*
* --------------------------------------
*
* 1.) What is POJO:
* Any java class which can be complied by using only JDK s/w is called POJO.
*
* a POJO is a simple Java object that does not depend on any external frameworks/dependency(Spring, Hibernate, or Servlets).


*✅ Corrected POJO Rules:
1️⃣ A POJO should be a normal Java class without framework dependencies.
2️⃣ It can have private fields (recommended for encapsulation).
3️⃣ It can have public getters and setters, but it’s not mandatory.
4️⃣ It can have a public no-argument constructor, but it’s not mandatory.
5️⃣ It must not extend framework-specific classes or implement specific interfaces (except Serializable, which is allowed but not required).

*  Servlet can be complied by Tomcat ,not java so when we implement servlet then it is not POJO.
*
* ✔ "Servlets are not POJOs."

Correct! Servlets require the javax.servlet API,
* which is not part of standard JDK. Since POJOs should not depend on external libraries,
*  servlets are not considered POJOs.

*
*
* example1:
* class demo {
* int id;
* String Name;
* }
* please tell me, Is it complied by JDK(java)?
* answer is Yes. then it is valid POJO
* ---------------------------------------
* Example2
* class Demo2 implements Runnable{
* //run(); //put some code
* }
* please tell me . Is it valid POJO?
* answer is yes. it is valid pojo because it is also complied by JDK(java)
* ------------------------------------
*
* Example 3
* class Demo3 implements Servlet{
* //doGet();
* //doPost();
* }
* please tell me is Demo3 is valid POJO?
* answer is No. because it is complied/run by Tomcat,not java
* so Demo3 is not valid POJO.
*
*
* */
public class POJODemo {
}

//Example of a POJO in Java

/*public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
*/

//❌ Example of a Non-POJO Class
//2️⃣ Spring Bean with Annotations (Non-POJO Example)
//import org.springframework.stereotype.Component;
//
//@Component
//public class SpringBean {
//    public void sayHello() {
//        System.out.println("Hello from Spring Bean!");
//    }
//}

/*
* ❌ Why is this NOT a POJO?

It uses @Component, which is a Spring annotation.
The class is now managed by Spring, making it dependent on Spring Framework.

* */


//1️⃣ Servlet (Non-POJO Example)
/*
* import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello, this is not a POJO!");
    }
}

* ❌ Why is this NOT a POJO?

It extends HttpServlet, which is part of the Servlet API (external dependency).
It depends on HttpServletRequest and HttpServletResponse, which are not part of core Java.

* */