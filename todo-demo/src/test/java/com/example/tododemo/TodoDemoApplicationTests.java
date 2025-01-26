package com.example.tododemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


@SpringBootTest
class TodoDemoApplicationTests {
    @Test
    void generateToken(){
        String token = JWT.create()
                .withIssuer("auth0")
                .withSubject("Para")  //token主体
                .withExpiresAt(Instant.now().plus(30, ChronoUnit.MINUTES))
                .sign(Algorithm.HMAC256("supersecret"));//签名算法
        System.out.println(token);
    }

    @Test
    void vertifyToken(){
        String info = JWT.require(Algorithm.HMAC256("supersecret"))
                .withIssuer("auth0")
                .build()
                .verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoMCIsInN1YiI6IlBhcmEiLCJleHAiOjE3Mzc4Nzg2MTZ9.dqQiOLrXe48gNqs_CPXjiy1Y4WzF16R0VtbbLVFj2qo")
                .getSubject();
        System.out.println(info);
    }
}
