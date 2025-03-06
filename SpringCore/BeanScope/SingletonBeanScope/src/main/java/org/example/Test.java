package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // Load Spring Container
        ApplicationContext ap= new ClassPathXmlApplicationContext("spring-config.xml");

        //No need to manually get MessageService in the Test class,
        // since it’s automatically injected into MessagePrinter.
//        MessageService ms1 =ap.getBean(MessageService.class);
//        MessageService ms2 =ap.getBean(MessageService.class);
//        System.out.println(ms1==ms2);//true

        MessagePrinter p1 = ap.getBean(MessagePrinter.class);
        MessagePrinter p2 = ap.getBean(MessagePrinter.class);

        System.out.println(p1.hashCode());//436546048
        System.out.println(p2.hashCode());//436546048
        System.out.println(p1==p2); //true

        p1.printMessage();

        // Close Context
        ((ClassPathXmlApplicationContext) ap).close();

    }
}


/*
*
* Explanation
Singleton Scope:

MessagePrinter is a singleton, meaning printer1 and printer2 refer to the same instance.
This is confirmed by (printer1 == printer2), which returns true.
Dependency Injection:

MessageService is injected into MessagePrinter through constructor-based DI.
messageService.getMessage() is called inside MessagePrinter, proving that the dependency works.

*
* */


/*
* What Kind of Resources Need to Be Closed?
Spring beans may hold resources that require proper cleanup, such as:

Database Connections
File Streams
Network Sockets
Thread Pools
If you don’t close the ApplicationContext, these resources might remain open, leading to memory leaks or resource exhaustion.


* */