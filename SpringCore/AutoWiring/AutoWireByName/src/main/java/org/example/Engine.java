package org.example;

/* --------------AutoWiring -----------
*
* we can inject object bean into target in 2 ways
 * 1.) Manual wiring:  such as we defined bean in bean.xml is called manual wiring
 *   such as propertyTag we used, ref attribute and constructor-arg we already used
 * 2.) Autowiring: it means IOC container will identify dependent bean and it will inject
 * into target bean ( we no need to use any ref attribute/property tag in bean configuration file)
 *   it will work based on below modes
 *   a.) byName
 *   b.) byType
 *   c.) Constructor
 *   d.) no
 *
 * Note: Autowiring will not work by default, we have to enable it
 *       <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byName | byType">
 *
 * no need to ref attribute and property tag to inject bean then used autowiring by name and by type etc.
 *
 *--------------------------------------------------------------
 *
 * 🔥 What is Autowiring in Spring?
    Autowiring is a feature in Spring that automatically injects dependencies into a bean
*   without explicitly defining them in the XML configuration or Java-based configuration.

    Instead of manually specifying dependencies using <constructor-arg> or <property>,
*   Spring will find and inject the required bean automatically based on its type or name.

    🎯 Why Use Autowiring?
✅ Reduces XML/Configuration Code (No need for explicit <constructor-arg> or <property>.)
✅ Automatically finds and injects dependencies
✅ Simplifies dependency injection
✅ Useful when we have multiple dependencies

🔹 Types of Autowiring in Spring
Autowire Type	Description
no (default)	No autowiring (explicit bean configuration required).
byType	        Finds a bean matching the property type and injects it.
byName	        Finds a bean with the same name as the property and injects it.
constructor	    Uses a matching constructor parameter type to inject dependencies.

 *
 *
 *
 *
* */

//📝 Example: Implementing Autowiring in Spring (Without Annotations)
//Let’s create an example where a Car class depends on an Engine class,
// and we use autowiring to inject the Engine bean into Car.


public class Engine {
    public Engine() {
        System.out.println("Engine instance created");
    }

    public void start() {
        System.out.println("Engine is starting...");
    }
}

