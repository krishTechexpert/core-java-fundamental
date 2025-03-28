package com.krish.securityProjectwithJPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/admin").hasRole("ADMIN")
                // add prefix ROLE_ in DB table in case of using hasRole method
                // when we used @preAuthorirzed then no need any prefix ROLE_
                .requestMatchers("/user").hasAnyRole("ADMIN","USER")
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults()); // here we customized our http request
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        //db s data lekar ayengy and load krewaynege
        return config.getAuthenticationManager();
    }

}
