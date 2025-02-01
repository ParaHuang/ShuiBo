package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean   //实现DI
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //指定访问规则
//        http.authorizeHttpRequests(方法需要的参数->操作);
        http
                .authorizeHttpRequests(auth->auth
                    .requestMatchers("/user/**").authenticated()    //通过认证就行
                    .requestMatchers("/admin/**").hasRole("ADMIN")  //通过认证，且拥有ADMIN角色
                    .anyRequest().permitAll())
                .formLogin(form->form.permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("112233"))
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
        //创建一个临时账号密码
    }

}
