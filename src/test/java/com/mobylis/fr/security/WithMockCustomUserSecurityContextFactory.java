//package com.mobylis.fr.security;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.test.context.support.WithSecurityContextFactory;
//import org.springframework.security.test.context.support.WithUserDetails;
//
///**
// * @author ANDRE
// * @since 04/03/2018
// */
//public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithUserDetails> {
//
//    @Override
//    public SecurityContext createSecurityContext(WithUserDetails annotation) {
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//
//        UserDetails principal = User.withUsername("user")
//                .username("user")
//                .roles("USER")
//                .password("{bcrypt}$2a$10$ZMTdGY/z1zstRmDl8YM81uWmPccox/LCfRz6A6fkzRAnbNuTkmkqe")
//                .build();
//
//        Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());
//
//        context.setAuthentication(auth);
//        return context;
//    }
//}
