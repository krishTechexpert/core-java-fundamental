package com.krish.securityProjectwithJPA.service;

import com.krish.securityProjectwithJPA.entity.User;
import com.krish.securityProjectwithJPA.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("user not found"));

       //to access predefined User method
       return new org.springframework.security.core.userdetails.User(
               user.getUsername(),user.getPassword(),
               true,true,true,true,
               user.getRoles()
                       .stream()
                       .map(role -> new SimpleGrantedAuthority(role.getName()))
                       .collect(Collectors.toSet())
       );
    }
}

