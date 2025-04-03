package com.krish.JWTDemo.controller;

import com.krish.JWTDemo.util.Jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JwtController {

    @Autowired
    private Jwtutil jwtutil;

    @PostMapping("/generate-token")

    public String generateToken(@RequestParam String username, @RequestParam String password){
        if("krish".equals(username) && "test123".equals(password)){
            // generate toke here
            return jwtutil.generateToken(username);
        }
        else {
            return "invalid credential";
        }
    }
    //secure api
    @GetMapping("/fund")
    public String fundTransfer(@RequestHeader(value="Authorization",required = false)
                               String authorizationHeader){
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            //token validate
            //"Bearer " -include- 0 to 6 index with space
            String token = authorizationHeader.substring(7);
            if(jwtutil.validateToken(token)){
                return "this is secure API, valid token";
            }else{
                return "Invalid token";
            }
        }else {
            return "Authorization header is missing";
        }
    }

}
