package com.websecurity.ApiWebSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*  As soon as I put this dependency in pom file such as  sprint-boot-starter-security then web security will be activated...
* what is user name and passowrd
* If we have not change anything then take password from console like
* Using generated security password: 1afca91a-e8e0-407e-8d24-f94b3dcb5f4e

* and username is: user
* http://localhost:8080/security
*
* Can we change default username and password ?
* yes we can do that., for this goto resource/application.properites
*
* spring.security.user.name=mytest
  spring.security.user.password=test
*
 *------------------------------
 *
 * spring security ka latest version 6.4.4 hai
 *
 * how to secure specific URL?
 * when we add security-starter in pom.xml file then
 * it will apply security filter for all http methods of our application
 *
 * jab koi http request, security filter k pass jati hai toh , spring security jo hai woh by default ,  default security chain filter ka bean(Object) bna ta hai
 * and es bean(class) ki default feature hai login page with username and password will show, otherwise bad credential
 *
 * In default behaviour, it can secure all api
 * but we want some of api will not secure then we can make our custom filter to unsecure some api
 * (we can do by making bean object and modify it)
 *
 * Now we want to change default behaviour of spring security,
 *
* */


@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public String test(){
        return "hello test";
    }
    @GetMapping("/getBalance") // it has access by either user or admin role
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String getBalance(){
        return "my current balance is : 50000";
    }
    @GetMapping("/fundTransfer")
    public String fundTransfer(){
        return "25000";
    }
    @GetMapping("/contact")
    public String getContactUs(){
        return "please contact us our support number 8967534821";
    }
    @GetMapping("/about")
    public String aboutUs(){
        return "I am about us page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String setPermission(){
        return "Only admin can set permission";
    }

}
