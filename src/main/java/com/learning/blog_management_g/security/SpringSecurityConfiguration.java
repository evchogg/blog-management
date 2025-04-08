package com.learning.blog_management_g.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //All requests should be authenticated
        httpSecurity.authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/**").permitAll()
                                .anyRequest().authenticated()

                )
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                        "/api/**"
                ));


        //If a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(withDefaults());


        return httpSecurity.build();
    }
}
