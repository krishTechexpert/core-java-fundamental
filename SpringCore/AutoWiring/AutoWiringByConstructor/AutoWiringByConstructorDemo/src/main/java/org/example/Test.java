package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("Bean.xml");

        Bank bank =ap.getBean(Bank.class);


        Account a1= (Account) ap.getBean("accountBean",bank,"krish");
        a1.showAccountDetails();
        System.out.println("------------------");
        Account a2= (Account) ap.getBean("accountBean",bank,"ravi");
        a2.showAccountDetails();
    }
}
