package org.example;

/*
* 2. Create the Singleton Bean (MessagePrinter)
This class depends on MessageService, and we will inject it using Spring.

 * */

public class MessagePrinter {
    private MessageService messageService;

    // Constructor-based Dependency Injection
    public MessagePrinter(MessageService ms){
        this.messageService=ms;
    }

    public void printMessage(){
        System.out.println(messageService.getMessage());
    }
}
