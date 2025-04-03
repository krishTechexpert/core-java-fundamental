package com.krish.securityProjectwithJPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* database name securityDemo
#   username krish password---root
#   username simran password ---123
* */


@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome(){
        return "Hello sir welcome to our office..." ;
    }

    @GetMapping("/user")
    // as simran user, when you hit enter username: simran and password: 123

    public String user(){
        return "Hello user....";
    }

    // simran are both user and admin we mapped in user_roles table
    @GetMapping("/admin")
    // as krish admin, when you hit enter username: krish and password: root
    // as simran admin, when you hit enter username: simran and password: 123


    public String admin(){
        return "Hello admin....";
    }

}
