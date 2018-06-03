//package com.mobylis.fr.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
///**
// * @author ANDRE
// * @since 04/03/2018
// */
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public MapReactiveUserDetailsService userDetailsRepository() {
//        UserDetails user = User.withUsername("user")
//                .username("user")
//                .roles("USER")
//                .password("{bcrypt}$2a$10$ZMTdGY/z1zstRmDl8YM81uWmPccox/LCfRz6A6fkzRAnbNuTkmkqe")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//
//        return http
//                .authorizeExchange()
//                .pathMatchers("/api/public/*").permitAll()
//                .anyExchange().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable()
//                .build();
//    }
//
//}