//--------- Autowiring --------------

/*
* we can inject object bean into target in 2 ways
* 1.) Manual wiring:  such as we defined bean in bean.xml is called manual wiring
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
* */

public class AutoWiring {
}
