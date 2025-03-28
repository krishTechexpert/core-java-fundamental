package com.websecurity.ApiWebSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    // frontend s test insert krehy into username parameter
    //step:1 user ko load kra do
    /*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // load single user
        //check username
        if(!username.equals("krish")){
            throw new UsernameNotFoundException("username not found");
        }
        //check password
        String encodePass = new BCryptPasswordEncoder().encode("testpassword");

        // on Demand , user load ho jyega after getting username and password
        return User.withUsername("krish").password(encodePass).roles("USER").build();

        // now we will verify loaded user in step 3
    }*/

    //------------------------------------------

    // If you want to load multiple user
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equals("raj")){
            String encodePass = new BCryptPasswordEncoder().encode("testpassword");
            return User.withUsername("raj").password(encodePass).roles("ADMIN").build();
        }
        if(username.equals("abc")){
            String encodePass2 = new BCryptPasswordEncoder().encode("test");
            return User.withUsername("abc").password(encodePass2).roles("USER").build();
        }
        throw new UsernameNotFoundException("user not found");
    }
}
