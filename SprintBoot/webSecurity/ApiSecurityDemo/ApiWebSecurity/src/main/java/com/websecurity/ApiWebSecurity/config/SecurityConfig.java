package com.websecurity.ApiWebSecurity.config;

import com.websecurity.ApiWebSecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration and @Bean ek satk work kerty hai

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // when you used @PreAuthorize on method
public class SecurityConfig {


    @Autowired
    private CustomUserDetailsService userDetailsService;


    //step 2 : it will runs after step 1 loaded user done in CustomUserDetailsService
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request
                // / --8080 or baseUrl or homepage, /about,  /contact page make unsecure,otherwise all secure api
                .requestMatchers("/","/about","/contact").permitAll()
                .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults()); // here we customized our http request
                return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    //step 3: this will responsible for validate username and password

    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder builder =http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return builder.build();

    }
}
