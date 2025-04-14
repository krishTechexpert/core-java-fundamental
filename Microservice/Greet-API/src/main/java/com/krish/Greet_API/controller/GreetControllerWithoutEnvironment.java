package com.krish.Greet_API.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetControllerWithoutEnvironment  {

    //for logger enable
    private static final Logger logger= LoggerFactory.getLogger(GreetControllerWithoutEnvironment.class);

    @GetMapping("/greet1")
    public String greetMsg(){
        logger.info("inside greetMsg method in Greet api");
        return "Good Morning , I am from Greet-API MS";
    }
}

/*
* we can enable and disable logger from admin server without application restart
* * http://localhost:1111/instances/3ec2b8d8f08a/loggers
    make Root is OFF inside Logger
 * try to hit greet api and check console..
 *
 * we need add this config for admin server
 * spring.boot.admin.client.url=http://localhost:1111/

*
* result: 2025-04-06T08:50:01.759+05:30  INFO [Greet-API,,,] 161093 ---
*  [Greet-API] [nio-9090-exec-7] [67f1f2e1e92d0aeb53ce752391809bbb-53ce752391809bbb]
* c.k.G.controller.GreetController : inside greetMsg method in Greet api

 *
* IN production, we can not add System.out.println() because console will not show in prod
*  that's why we used Logger to show log file
* such as to print message which work like console.log() in javascript
*
* here Microservice part 1 done here
*
* */