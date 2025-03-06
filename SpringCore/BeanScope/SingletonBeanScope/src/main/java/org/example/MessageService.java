package org.example;

/*
* Sure! In Spring, the Singleton scope means that a single instance of a bean is created
*  and shared across the entire application context.
* Even if you request the bean multiple times, the same instance will be returned.


 * */


/*
* Example: Singleton Bean with Dependency Injection
    We will create two beans:

1.) MessageService (Dependency) – provides a message service.
2.) MessagePrinter (Singleton Bean) – depends on MessageService and prints messages.

* */
//1. Create the Dependency (MessageService)
//This class provides a simple method to return a message.


public class MessageService {
    public String getMessage(){
        return "Hello from MessageService!";
    }
}
