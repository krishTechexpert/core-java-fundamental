package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap =new ClassPathXmlApplicationContext("bean.xml");

        Car car = ap.getBean(Car.class);

        car.drive();
    }
}

//output
/*
* KSeries default constructor
car default constructor...
Car  setter method...
Start KSeries Engine
Car Running...
* */


/*------------------byType--------------
        * byType: it means IOC identify dependent bean object based on data
*           type of the varaible in target class
*
        *   <bean id="engine1(anyName)" class="org.example.Kseries" />
        * * <bean id="engine2" class="org.example.Mhawkseries" /> it will give ambugity error
* because two object engine1,engine2 is of same type Engine . check solution

 * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>
        *
        * -------- Solution 1 (autowire-candidate="false") ----------
        *   <bean id="KengineBean" class="org.example.Kseries" />
        * * <bean id="mhawkEngine" class="org.example.Mhawkseries" autowire-candidate="false" />
        *
        * 🔹 Why Use autowire-candidate="false"?
It prevents Spring from considering the bean for autowiring.(mhawkEngine will not participate in autowiring)
Even if there are matching types, Spring will ignore this bean.
Useful when you have multiple beans of the same type but only want some to be
* injected automatically.

        *
        *  * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>

        *
        * -------- Solution 2 (primary="true") ----------
        *   <bean id="KengineBean" class="org.example.Kseries" primary="true" />
        * * <bean id="mhawkEngine" class="org.example.Mhawkseries" />
        * *
        *  * <bean id="car" class="org.example.Car" scope="prototype" auto-wire="byType"/>
        *
        * now KengineBean take priority and mhawkEngine will ignored
 * */


