package com.krish.Welcome_API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    // way-1: Rest Template to consume Greet API
    // but In Rest Template, we need to provide fixed Url
    //such as String greetMsg =  restTemplate.getForObject("http://localhost:9090/greet",String.class);
    @Bean
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
