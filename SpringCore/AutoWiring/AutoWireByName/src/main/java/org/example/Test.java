package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("Bean.xml");

        Car car = ap.getBean(Car.class);

        car.drive();
    }
}

//output
//Engine instance created
//Car is driving...
//Engine is starting...

/*
* * -------------------- byName-----------------
 * byName: it means IOC will identify dependent bean object based on bean id or bean name

 * <bean id="engine" class="org.example.Kseries" />//engine used ho reha hai byName
 * yha per engine represent instance varaible  hai for private Engine engine;
 *
 * <bean id="engine1" class="org.example.Mhawkseries" />
 *
 * <bean id="car" class="org.example.Car"  auto-wire="byName"/>

 *
* */