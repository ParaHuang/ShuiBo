package com.example.tododemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JWTService {
    private static final Algorithm algorithm = Algorithm.HMAC256("supersecret");

    public String generateToken(String username){
        String token = JWT.create()
                .withIssuer("auth0")
                .withSubject(username)  //token主体
                .withExpiresAt(Instant.now().plus(30, ChronoUnit.MINUTES))
                .sign(algorithm);//签名算法
        return token;
    }

    public String validateToken(String token) {
        String info = JWT.require(algorithm)
                .withIssuer("auth0")
                .build()
                .verify(token)
                .getSubject();
        return info;
    }
}
