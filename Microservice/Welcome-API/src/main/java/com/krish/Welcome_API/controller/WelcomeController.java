package com.krish.Welcome_API.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    //for logger enable
    private static final Logger logger= LoggerFactory.getLogger(WelcomeController.class);


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GreetFeignClient greetFeignClient;

    /*way-1 rest Template (not recommended)
    @GetMapping("/welcome")
    public String welcome(){
        String welcomeMsg =  " Hi, I am from Welcome API";
       String greetMsg =  restTemplate.getForObject("http://localhost:9090/greet",String.class);
        // it return string so we add String.class
        return greetMsg + welcomeMsg;
    }*/

    //way-2 feign client(good and recommended)
    @GetMapping("/welcome")
    public String welcome(){
        logger.info("inside Welcome method in welcome api");

        String welcomeMsg =  " Hi, I am from Welcome API";
        String greetMsg = greetFeignClient.invokeGreetApi(); //very simple
        return greetMsg + welcomeMsg;
    }
}
