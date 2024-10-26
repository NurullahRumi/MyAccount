package com.nrproject.myaccount.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define a query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select ur_id, pw, enabled from nr_users where ur_id =?;"
        );

        // define a query to retrieve role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select ur_id, roles from nr_roles where ur_id = ?;"
        );


        return jdbcUserDetailsManager;

    }





    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers( HttpMethod.GET, "/api/income/incomes").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/income/incomes/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/api/income/addIncome").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/income/editIncome").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/month/months").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/month/months/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/month/addMonth").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/month/editMonth").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/month/deleteMonth").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/month/deleteMonthById/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/user/addUser").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"api/user/allUsers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/userRole/addUserRole").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/income/session").hasRole("EMPLOYEE")
        )
                .httpBasic(Customizer.withDefaults()) // use HTTP Basic auth
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
                .csrf(csrf -> csrf.disable())
                .build();

    }

}
