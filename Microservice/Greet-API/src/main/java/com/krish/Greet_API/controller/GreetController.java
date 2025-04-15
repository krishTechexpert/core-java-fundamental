package com.krish.Greet_API.controller;

import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetController {

    //for logger enable
    private static final Logger logger= LoggerFactory.getLogger(GreetController.class);

    @Autowired
    private Environment environment;

    @GetMapping("/greet")
    public String greetMsg(){
        logger.info("inside greetMsg method in Greet api");
        String port = environment.getProperty("server.port");///greet endpoinst kis port
        // per chal reha hai bata do by using environment
        System.out.println("running on port= "+port);
        return "Good Morning , I am from Greet-API MS "+port;
    }

}
    /* In Microservice part 2 start here in which we learn how Greet-api MS runs on different
    -2 port such as 9090,9091,9092

     and also learn for api gateway filtering and environment

     By Using Environment varaible we can check which port number greet-api runs.
    * 1.)
    * suppose we want to check which port number running for greet-api without specify
    * port in application.properties files such as server.port = server.port=9090
    * then first make it server.port=9090 disabled it and used
    * private Environment env;
    -----------------------------------------------
    2.)
    Now we will create jar file of greet-api by using maven

    click on maven icon -> Lifecycle ->
    select clean and install and play/click green run button
    then you will find under target -> Greet-API-0.0.1-SNAPSHOT.jar
    --------------------------------------------
    3.) start discovery server, admin server,zipkin, welcome api
    and check in discovery server it is showing in it.
        http://localhost:8761/
        http://localhost:1111/applications
        http://localhost:9411/zipkin/
        welcome api is listed here.
        http://localhost:8081/welcome

    4.) now go to cmd
Microservice/Greet-API/target$ java -jar Greet-API-0.0.1-SNAPSHOT.jar --server.port=9091
successfully run on cmd console and you will see message like:
2025-04-13T20:10:52.722+05:30  INFO
[Greet-API,67fbccf462d5fe1d62fcb639c8be9147,62fcb639c8be9147] 85495 ---
[Greet-API] [nio-9091-exec-9] [67fbccf462d5fe1d62fcb639c8be9147-62fcb639c8be9147] 4
c.k.G.controller.GreetController         : inside greetMsg method in Greet api
running on port= 9091

http://localhost:9091/greet
Good Morning , I am from Greet-API MS 9091

till now everytjing is working fine

---------------------------------------------------------

5.) now try to greet-api run on  on 9092 and 9093 port as well

Microservice/Greet-API/target$ java -jar Greet-API-0.0.1-SNAPSHOT.jar --server.port=9092
http://localhost:9092/greet
Good Morning , I am from Greet-API MS 9092


Microservice/Greet-API/target$ java -jar Greet-API-0.0.1-SNAPSHOT.jar --server.port=9090
http://localhost:9090/greet
Good Morning , I am from Greet-API MS 9090

Now till now 3 instance of greet-api MS run on different -2 port
we acheived that till now.
-------------------------------------------------

6.) Now we will see magic of load balancing..
open postman/or run in browser and run/hit multiple times: http://localhost:8081/welcome
same url on different port it will take help from Eurika
then you will see that load balancing manage automatically when ou hit single /welcome
Good Morning , I am from Greet-API MS 9091 Hi, I am from Welcome API
Good Morning , I am from Greet-API MS 9090 Hi, I am from Welcome API
Good Morning , I am from Greet-API MS 9092 Hi, I am from Welcome API

------------ End here --------------

* */

/** Let see how load balance manage without feign client
 *
 * like banking,enterprise,product based company don't like to used open source tool
 * so y company apny hi internal algorithm likty hai
 *  so wsee hi y load balance ko implement kerny k liye , in api gateway ko apni
 *  algorithm d deta hai suppose
 *
 *  if api gateway check if request is coming from more than 3 then it will used
 *  modolus (%) opeartor ka used kerky each instance ko index assign ker deta hai
 *  such as 0,1,2
 *
 *  when hit first request, 0%3=0 (index) means runs 9090 instance
 *  when hit second request, 1%3=1 (index) means runs 9091 instance
 *  when hit third request, 2%3=2 (index) means runs 9092 instance
 *
 *  again when hit fourth request, 3%3=0 (index) means runs 9090 instance
 *  again when hit fifth request, 4%3=1 (index) means runs 9091 instance
 *  again when hit six request, 5%3=2 (index) means runs 9092 instance
 *
 *  and continue this process.....
 *
 *  Just for understanding interview perespective...
 *
 *---------------------------------------
 * **/

/**
 * Let's start how to make API Gateway
 *
 * Routing:
 * As we already see greet api has running on multiple instance such as 9090,9091,9092
 * and welcome api runs on single instance
 *
 * User request first comes to Api gateway which is running on
 * * default port : 3333 after that further move to discovery server.
 * For example:
 * * user hit suppose http:localhost:3333/welcome MS then we will configure
 * * in application.properties files such as  /welcome: Welcome-API
 * ---------------------------- for example
 * to Check API-Gateway project
 * #Route config for welcome api
 * spring.cloud.gateway.routes[0].id=welcome-api
 * spring.cloud.gateway.routes[0].uri=lb://Welcome-API
 * spring.cloud.gateway.routes[0].predicates[0]=Path=/welcome
 *
 * # routing works always on key-value pair such as /welcome : Welcome-API
 * #user hit http://localhost:3333/welcome
 *
 * #Route config for greet api
 * spring.cloud.gateway.routes[1].id=greet-api
 * spring.cloud.gateway.routes[1].uri=lb://Greet-API
 * spring.cloud.gateway.routes[1].predicates[0]=Path=/greet
 * spring.main.web-application-type=reactive
 *----------------------------------------------
 * then it will look into  discovery server..hey you have registered Welcome-API
 * please route further to welcome api and In welcome api we used feign client which handle
 * internal load balancing manage automatically.
 *
 * */