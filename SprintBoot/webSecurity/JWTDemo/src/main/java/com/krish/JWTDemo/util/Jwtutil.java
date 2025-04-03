package com.krish.JWTDemo.util;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class Jwtutil {
    private static final String SECRET_KEY_STRING="krish#123456789flsdlkfljksdjfklsdjflksdj454859084gkfjkgjfljglfjgkjflkgjflkgjfklgj";

    private final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    public String generateToken(String username){

        System.out.println("secret key"+SECRET_KEY);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*30))//30 seconds
                .signWith(SECRET_KEY)
                .compact();
        System.out.println("Generated Token="+token);
        return token;
    }

    public Boolean validateToken(String token){
            try{
                Jwts.parserBuilder().setSigningKey(SECRET_KEY)
                        .build().parseClaimsJws(token);
                return true;
            }
            catch(ExpiredJwtException e){
                System.out.println("Token expired"+e.getMessage());
                return false;
            }
            catch(SignatureException e){
                System.out.println("Invalid Jwt signature"+e.getMessage());
                return false;
            }
            catch(Exception e){
                System.out.println("JWT exception"+e.getMessage());
                return false;
            }
    }
}
