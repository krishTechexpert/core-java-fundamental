package com.example.PaymentGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    // to implement CORS without using annotation (@CrossOrigin on on each controller.)
    @Bean
    public WebMvcConfigurer config(){
           return new WebMvcConfigurer() {
               @Override
               public void addCorsMappings(CorsRegistry registry) {
//This means: "Apply the CORS rules to any route that starts with /api/ (like /api/orders, /api/pay, etc.)".
                   registry.addMapping("/api/**")
                           .allowedOrigins("http://localhost:5500","http://127.0.0.1:5500")
                           .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
                           .allowedHeaders("*")
                           .allowCredentials(true);
//Allows cookies or tokens (like JWTs in headers) to be included in the request — often needed for login sessions.


               }
           };
    }
}
