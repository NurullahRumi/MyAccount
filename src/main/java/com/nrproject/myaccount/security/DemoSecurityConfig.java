package com.nrproject.myaccount.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);

    }





    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers( HttpMethod.GET, "/api/incomes").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/incomes/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/api/addIncome").hasRole("MANAGER")


        );

        // use HTTP Basic auth
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }



    /*   @Bean
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
*/


}
