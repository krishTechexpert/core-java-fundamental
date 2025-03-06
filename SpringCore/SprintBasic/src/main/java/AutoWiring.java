//--------- Autowiring --------------

/*
* we can inject object bean into target in 2 ways
* 1.) Manual wiring:  such as we defined bean in bean.xml is called manual wiring
*   such as propertyTag we used, ref attribute and constructor-arg we already used
* 2.) Autowiring: it means IOC container will identify dependent bean and it will inject
* into target bean ( we no need to use any ref attribute in bean configuration file)
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
* -------------------- byName-----------------
* byName: it means IOC will identify dependent bean object based on bean id or bean name
* <bean id="engine" class="org.example.Kseries" />//engine used ho reha hai byName
* yha per engine represent instance varaible  hai for private Engine engine;
*
* <bean id="engine1" class="org.example.Mhawkseries" />
*
* <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byName"/>
*
* ------------------byType--------------
* byType: it means IOC identify dependent bean object based on data
*           type of the varaible in target class
*
*   <bean id="engine1(anyName)" class="org.example.Kseries" />
* * <bean id="engine2" class="org.example.Mhawkseries" /> it will give ambugity error
* because two object engine1,engine2 is of same type Engine . check solution

 * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>
 *
 * -------- Solution 1 (autowire-candidate="false") ----------
 *   <bean id="engine1" class="org.example.Kseries" />
 * * <bean id="engine2" class="org.example.Mhawkseries" autowire-candidate="false" />
 *
 * 🔹 Why Use autowire-candidate="false"?
It prevents Spring from considering the bean for autowiring.(engine2 will not participate in autowiring)
Even if there are matching types, Spring will ignore this bean.
Useful when you have multiple beans of the same type but only want some to be
* injected automatically.

 *
 *  * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>

*
* -------- Solution 2 (primary="true") ----------
 *   <bean id="engine1" class="org.example.Kseries" primary="true" />
 * * <bean id="engine2" class="org.example.Mhawkseries" />
 * *
 *  * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>
*
* now engine1 take priority and engine2 will ignored
 * */



public class AutoWiring {
}
