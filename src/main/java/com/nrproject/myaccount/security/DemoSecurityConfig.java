package com.nrproject.myaccount.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails rumi = User.builder()
                .username("rumi")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails munni = User.builder()
                .username("munni")
                .password("{noop}test456")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails nuju = User.builder()
                .username("nuju")
                .password("{noop}test789")
                .roles("EMPLOYEE")
                .build();

        


        return new InMemoryUserDetailsManager(rumi, munni, nuju);
    }

}
