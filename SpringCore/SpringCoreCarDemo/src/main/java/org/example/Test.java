package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //Starting IOC
        ApplicationContext ap = new ClassPathXmlApplicationContext("Beans.xml");// when you run this line only you will see Car/KSeries ka object bn gya hai such as car default constructor... and KSeries default constructor

        /*
        *   KSeries default constructor
            car default constructor...
            *
            * but you surprised here why first KSeries constructor call ? because in Beans.xml file we first defined <bean id="kseriesId" class="org.example.KSeries"> which totally depends how you defined class in Bean.xml
            * both object managed by IOC in Heap Area which also take care of life cycle for both object
        * */
        Car car = ap.getBean(Car.class);//we can hold here car object

        KSeries bean = ap.getBean(KSeries.class); //we can hold here kseries object

        //next step to inject
        // now both object has been created , let us see how we can inject Kseries object into Car which will store inside Engine engine varaible

       // car.drive();// this.engine" is null because we have not inject dependency injection it means in xml file you have not used any property tag
//-------------------------------------------------------------------
        /* way-1 of injecting engine property using setter method
        <bean id="car" class="org.example.Car">
        <property name="engine" ref="kseriesId"/> engine varaible of Engine such as private Engine engine -->
        </bean>*/

        //--------------------------------------------------------
        /* way-2, But if you want to inject by using constructor
            then used contructor-arg tag  such as
            <constructor-arg name="engine" ref="kseriesId" />

        * if you used both method then setter method will override constructor, As you already know
        * */



        car.drive();
    }
}

/*----------- Field Injection
If you want to perform field injection (without using annotations) in Spring XML
(bean.xml), you cannot do it directly like setter injection or constructor injection.
However, you can combine setter injection with reflection to achieve the same effect.

 📌 What is Field Injection?
Field Injection means directly assigning a value to a field (without using a constructor
 or setter method).
Spring does not support field injection through XML directly because XML-based configuration
works with setter and constructor injection.

⛔ Why Doesn't Spring Support Field Injection via XML?

In XML, Spring can only call methods (setters or constructors).
Field injection requires direct access to private variables, which is not possible in XML-based injection.
Solution? We still use setter injection, but we remove the setter method in Java and use reflection.

✅ Workaround: Using Reflection for Field Injection
Since XML doesn't support direct field injection, you can remove setter methods and
allow Spring to inject dependencies using reflection.


package org.example;

//🔹 Step 1: Define Dependency Class (Engine)

public class Engine {
    private String type = "K-Series Engine"; // Field to be injected

    public String getType() {
        return type;
    }
}

🔹 Step 2: Define Main Class (Car) Without Setter
package org.example;

public class Car {
    private Engine engine; // Field injection (No Setter or Constructor)

    public void showEngine() {
        System.out.println("Engine Type: " + engine.getType());
    }
}

🔹 Step 3: Configure bean.xml (Use property for Field Injection)
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define Engine Bean -->
    <bean id="engineBean" class="org.example.Engine" />

    <!-- Inject Engine into Car (Even without setter) -->
    <bean id="carBean" class="org.example.Car">
        <property name="engine" ref="engineBean" />
    </bean>

</beans>

🔹 Step 4: Run Spring Application
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Car car = (Car) context.getBean("carBean"); // Get Car bean
        car.showEngine(); // Should print "Engine Type: K-Series Engine"
    }
}

🔍 How is Field Injection Happening Here?
Spring uses reflection to directly inject the engine variable even though there's no setter method.
This happens because Spring internally uses reflection to access private fields during property injection.
It behaves like field injection but still follows setter injection internally.

 */


/*
* 💡 Key Takeaways
✔ Spring does not support direct field injection via XML.
✔ Instead, Spring uses setter injection under the hood, even without setter methods (via reflection).
✔ Use property tag in XML to achieve the same effect as field injection.
✔ It’s better to use constructor or setter injection instead of forcing field injection.









*
* */