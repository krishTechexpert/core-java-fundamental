package com.krish.Welcome_API.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// it work same as JPA
@FeignClient(name="GREET-API") //it will ask from discovery server that
                               // do you have any MS name GREET-API
public interface GreetFeignClient {
    @GetMapping("/greet")
    public String invokeGreetApi();
}
//run time per springBoot ,GREET-API MS ka object bna dega then usko consume kerny
// k liye humko ek method(invokeGreetApi) banana hai same as JPS


/*Note:
 feign client , discovery server s pochega ki do you have Greet API Microservice
 then it will return the url of greet API MS ka

 don't need to directlty communicate from Welcome API with Greet API (which is good)

 add this anontation @EnableFeignClients

 */

/*
Way 2:  OpenFeign : Y discovery server k sath hi chalta hai..manadatory/majboori hai

// feign client , discovery server s pochega ki do you have Grret API Microservice
then it will return the url of greet API MS ka

✅ Why OpenFeign is Better than RestTemplate
1. Service Discovery Support
        Works easily with Eureka. You can just provide the service name. as above code

2. Built-in Load Balancing
        It uses Ribbon or Spring Cloud LoadBalancer under the hood to balance requests
        among multiple instances automatically.

        3. Less Code, More Declarative
        Just an interface and annotations — no need to write HTTP call logic.

4. Better Integration with Spring Cloud
        Easily integrates with circuit breakers (like Resilience4J), retries, fallbacks, etc.

        ---------------------------------------------

        🧠 Summary
        Feature				RestTemplate		OpenFeign
        Hardcoded URL			❌ Yes			✅ No
        Service Discovery		❌ No			✅ Yes
        Load Balancing			❌ No			✅ Yes
        Code Simplicity			❌ Verbose		✅ Declarative
        Spring Cloud Integration	❌ Manual	✅ Tight integration

http://localhost:8081/welcome

*
        * */
