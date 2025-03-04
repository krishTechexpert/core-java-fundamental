package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * https://medium.com/@dulanjayasandaruwan1998/a-comprehensive-guide-to-working-with-spring-core-d6c58718eb6f
 *
 * Step 1: Set Up Your Project
 * First, create a new Maven project and add the Spring Core dependency to your pom.xml file:
 *
 *  Step 2: Define Your Beans
 *  Create a simple class representing a bean:
 *
 *  Step 3: Configure Your Beans
 *  Create a configuration file bean.xml inside main/resources to define your beans:
 *
 *  Step 4: Initialize the Spring Container
 *  Create a main class to initialize the Spring container and retrieve the bean:
 */
public class App 
{
    public static void main( String[] args )
    {
        // Step 1: Load Spring Configuration File (bean.xml) and all is done by IOC
        /*
        * ClassPathXmlApplicationContext("bean.xml") loads the bean.xml file.
Spring(IOC) read the file, finds the <bean> definition, and creates a HelloWorld object.
It injects "Hello Spring!" into the message variable.
        * */
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // Step 2: Retrieve the Bean from Spring Container
        HelloWorld obj = (HelloWorld)context.getBean("helloWorldID");// Bean ID from XML

        // Step 3: Use the Bean
        System.out.println(obj.getMessage());//Hello Spring
    }
}

/*
* Step 1: Understanding the Components
Your Spring program consists of the following parts:
1️⃣ A Java class (HelloWorld) – Defines a message property with getter and setter.
2️⃣ A Spring XML Configuration file (bean.xml) – Configures a Spring bean.
3️⃣ A Main class (App) – Loads the Spring container(IOC) and retrieves the bean.


* */

/*
* 📌 What is IoC (Inversion of Control)?
Before IoC (Traditional Java): We create objects manually using new.
With IoC (Using Spring): Spring creates and manages objects for us.
In simple terms, IoC means we don't create objects manually;
* instead, we delegate this responsibility to the Spring Container(IOC).


* */


/*
* 🔹 With Spring IoC (Your Example)

ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
HelloWorld obj = (HelloWorld) context.getBean("helloWorldID");
*
Spring creates the HelloWorld object (You never wrote new HelloWorld()).
Spring injects the message property (Setter injection is automatically applied).
Spring manages the object lifecycle.
* */

/*
* 📌 Where Exactly Does IoC Come Into Picture?
1️⃣ Spring IoC Container Reads bean.xml

Finds <bean id="helloWorldID" class="org.example.HelloWorld">
Creates an object of HelloWorld.
*
2️⃣ IoC Injects Dependencies (message)

<property name="message" value="Hello Spring!"/>
Calls setMessage("Hello Spring!") automatically.
*
3️⃣ IoC Returns the Bean When Requested

HelloWorld obj = (HelloWorld) context.getBean("helloWorldID");
We just ask Spring, and it gives us a ready-to-use object.

*
* */



/*
*  Try to understand in simple terms
*
* 🛠 Normally, You Create Objects Yourself (Without Spring IoC)
Imagine you are making a tea shop.

Without IoC, you do everything yourself:
Buy ingredients ☕
Make tea 🍵
Serve customers 🍽
Similarly, in Java, you usually create objects manually like this:
public class App {
    public static void main(String[] args) {
        HelloWorld obj = new HelloWorld(); // We create the object manually
        obj.setMessage("Hello Spring!");   // We manually set the message
        System.out.println(obj.getMessage());
    }
}
Here, we control object creation (new HelloWorld()) and dependency injection (setMessage()).
---------------------------------------------------------------------------------------

*
* 📌 What Happens in Your Spring IoC Example?
Now, imagine you hire a worker (Spring IoC) to do everything for you.

The worker buys ingredients, makes tea, and serves customers for you.
You just ask for tea, and it's ready! 🍵✅
Similarly, in Spring:
*
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
HelloWorld obj = (HelloWorld) context.getBean("helloWorldID");

* Spring IoC does the work for you:
1️⃣ Creates the object (HelloWorld) without new HelloWorld()
2️⃣ Sets the message (Hello Spring!) automatically
3️⃣ Gives you the ready-to-use object
You just call getBean(), and Spring gives you a fully configured object ✅.

📌 IoC in Simple Words
Spring IoC means you DON’T manually create objects. Instead, Spring does it for you!
Spring controls object creation, dependency injection, and lifecycle.
* You just request an object, and Spring gives it ready to use! 🎯


*
* */