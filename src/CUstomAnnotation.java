//-------- what does mean by Annotation--------------

/* Chat GPT

An annotation in Java is a special kind of metadata that
we use to provide extra information about code without changing how it works.



Annotations are used for:
✅ Giving instructions to the compiler.
✅ Helping frameworks (like Spring) process code.
✅ Accessing metadata using reflection at runtime.
-------------------------------------
Java Class Metadata (Annotations & Reflection API)
Java uses metadata in annotations to describe class properties.

🔹 Examples of Java metadata:

Annotations (@Override, @Entity, @Test)
Class Name & Methods
Modifiers (public, private, static)

📌 Summary Table: Types of Metadata
Metadata Type	                Examples
File Metadata	                Name, Size, Type, Created Date, Author
Image Metadata	                Camera Model, Resolution, GPS Location
Webpage Metadata	            Title, Description, Keywords (SEO)
Database Metadata	            Tables, Columns, Data Types, Keys
Java Class Metadata	            Class Name, Annotations, Methods
Network Metadata	            IP Address, Protocol, MAC Address


📌 Why is Metadata Important?
✅ Helps search engines understand webpages (SEO).
✅ Makes database management easier.
✅ Helps organize files and images efficiently.
✅ Enables network security and monitoring.
✅ Helps Java programs process annotations.



---------------------------------------------*/

 // --------- By Ashwini Ginee-------
/*
* Annotation internally used reflection api(private member,methods,annotation etc ko access kerny k liye used hoti hai)
*
* when we complie both classes it will create .class file As we know already
    MyAnnotation.class file
    CustomAnnotation.class file

* jab MyAnnotation.class file load hogi toh JVM uski value ko set ker dega inside
@interface MyAnnotation {
	String value();//esko value mil jye gi yha per
}
* --------------------------------------------
 *
* */

/*
* 🔹 @interface is used to define a custom annotation.
🔹 String value(); → This is an element that must be assigned a value when using this annotation.

* */

//1️⃣ Defining a Custom Annotation

//@interface MyAnnotation{
//    String value();  // This is an element inside the annotation
//}

/*2️⃣ Using the Annotation
🔹 @MyAnnotation("Custom Annotation")

This means we are applying the annotation to the CustomAnnotation class.
"Custom Annotation" → This is the value assigned to the value() element in @MyAnnotation.

 */

//@MyAnnotation("Custom Annotation")
//public class CustomAnnotation {
//    public static void main(String[] args) {
//        System.out.println("hi");
//    }
//}


/*3️⃣ What Happens Internally?
        ✔ When the Java compiler compiles the code, it generates .class files:

        MyAnnotation.class → Contains metadata of the annotation.
        CustomAnnotation.class → Contains the annotation applied to the class.

  ✔ When CustomAnnotation.class is loaded by the JVM,
  the annotation is stored in the class metadata.
  ✔ We can access this annotation at runtime using Reflection API (more on this later).

*/

/*
* 📌 Understanding Reflection API and Annotations
What is Reflection API?
Reflection API in Java allows us to access private members, methods, and annotations at runtime.


*
* */


//📌 Example: Reading the Annotation Value using Reflection

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)  // Annotation is available at runtime

//es annotation ko class k sath used kerna hai,ya phir method k sath used kerna hai etc
@Target(ElementType.TYPE)   //it means class level per lga sekty hai annotation // annotation can only be applied to classes, interfaces, or enums.

@interface MyAnnotation1 {
   String value();  // This is an element inside the annotation
    //it is an method but inside annotation it treat as parameter
}

@MyAnnotation1("Custom Annotation")// yha per class k sath used ker rehy hai
public class CUstomAnnotation {
    public static void main(String[] args) throws Exception {
        Class<CUstomAnnotation> obj = CUstomAnnotation.class;

        // Check if the class has @MyAnnotation
        if (obj.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = obj.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value: " + annotation.value());//Annotation Value: Custom Annotation
        }

        //second way
        // Access annotation value using Reflection
        MyAnnotation annotation = CustomAnnotation.class.getAnnotation(MyAnnotation.class);
        System.out.println("Annotation Value: " + annotation.value());//Annotation Value: Custom Annotation

    }
}
// output
//Annotation value: Custom Annotation

/*📌 Key Takeaways
1️⃣ Annotations provide metadata about code but don’t change execution.
2️⃣ Custom annotations are created using @interface.
3️⃣ Annotations can be accessed at runtime using Reflection API.
4️⃣ @Retention(RetentionPolicy.RUNTIME) makes the annotation available at runtime.*/


/*
* 📌 Where Are Annotations Used in Java?
✅ Built-in annotations: @Override, @Deprecated(first annotation introduced in jdk1.1), @FunctionalInterface, etc.
✅ Frameworks: Spring Boot, Hibernate, JUnit (e.g., @Autowired, @Test, @Entity).
✅ Logging and Serialization: Jackson @JsonProperty, Lombok @Getter.
    Jackson--convert into json format
* */

/*
*📌 1️⃣ @Override (Method Overriding): This annotation ensures that a method is correctly overriding a method from the parent class.

📌 2️⃣ @Deprecated (Marking Methods as Outdated): This annotation warns developers that
* a method/class should no longer be used.
--------------------------------------------
📌 3️⃣ @FunctionalInterface (For Functional Programming in Java 8+)
This annotation ensures that an interface has only one abstract method,
* making it valid for lambda expressions.

@FunctionalInterface
interface MyFunction {
    void sayHello();  // Only one method is allowed
}

// Using lambda expression
public class LambdaExample {
    public static void main(String[] args) {
        MyFunction func = () -> System.out.println("Hello from Lambda!");
        func.sayHello();
    }
}
✔ Ensures only one abstract method exists.
✔ Supports Lambda expressions in Java 8+.
---------------------------------------------------

* 📌 4️⃣ @SuppressWarnings (Hiding Compiler Warnings)
This annotation hides warnings that might not be important.

public class WarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        java.util.ArrayList list = new java.util.ArrayList();  // No generics (unsafe)
        list.add("Hello");
        list.add(100);  // Mixing types (bad practice)
        System.out.println(list);
    }
}
✔ Prevents compiler warnings about unchecked type usage.
❌ Be careful—it hides warnings, but it doesn't fix bad code.

-------------------------------------------------------
* 📌 5️⃣ @Retention (Retention Policy)
Defines how long an annotation should be available.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // Annotation is available at runtime
@interface MyAnnotation {
    String value();
}

@MyAnnotation("Hello Annotation!")
class TestClass {
    public static void main(String[] args) {
        // Access annotation value using Reflection
        MyAnnotation annotation = TestClass.class.getAnnotation(MyAnnotation.class);
        System.out.println("Annotation Value: " + annotation.value());//Annotation Value: Custom Annotation

    }
}

✔ RetentionPolicy.RUNTIME → Annotation is available at runtime, so we can access it using Reflection API.

-----------------------------------------
*
* 📌 6️⃣ @Test (JUnit Testing) : Used in JUnit for unit testing in Java.

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MathTest {
    @Test
    public void testAddition() {
        int result = 5 + 5;
        assertEquals(10, result);
    }
}
✔ @Test tells JUnit that this method is a test case.
✔ Ensures correct results in automated testing.

* ---------------------------------------------

📌 7️⃣ @SpringBootApplication (Spring Boot) (Very Imp) :
*        Used in Spring Boot applications to start the app.

* import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
✔ Marks this as a Spring Boot application.
✔ Automatically configures the Spring framework.
-----------------------------------------------------

* 📌 @Target(ElementType.TYPE)
* @Target(ElementType.TYPE) is used in Java annotations to specify that the
* annotation can only be applied to classes, interfaces, or enums.

* Explanation:
@Target is a meta-annotation (an annotation used on another annotation).
ElementType.TYPE means the annotation can be used on any type (class, interface, or enum).

* import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@interface MyAnnotation {
}
//Now, this annotation can only be applied to classes, interfaces, or enums:

* But if you try to apply it to a method or field, it will cause a compilation error:

* class AnotherClass {
    @MyAnnotation  // ❌ Compilation error! Not allowed on methods.
    public void myMethod() {
    }
}

* Other ElementType Options:
Besides ElementType.TYPE, you can use:

ElementType.METHOD → For methods
ElementType.FIELD → For fields
ElementType.PARAMETER → For parameters
ElementType.CONSTRUCTOR → For constructors


 *
* */


/*
* 📌 Summary
Annotation	            Purpose
@Override	            Ensures method is correctly overriding
@Deprecated	            Marks methods/classes as outdated
@FunctionalInterface	Ensures interface has only one method
@SuppressWarnings	    Hides compiler warnings
@Retention	            Defines annotation retention policy
@Test	                Used in JUnit for testing
@SpringBootApplication	Used in Spring Boot apps

* */

/*
* 📌 Final Thoughts
Annotations don’t change how code runs, but they give extra information.
Java frameworks like Spring, Hibernate, JUnit use annotations heavily.
You can also create your own custom annotations for special use cases.
Wou
* */
