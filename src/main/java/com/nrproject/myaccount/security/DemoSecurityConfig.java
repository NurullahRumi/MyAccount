package com.nrproject.myaccount.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define a query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_name, pw, enabled from nr_members where user_name =?;"
        );

        // define a query to retrieve role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_name, role from nr_roles where user_name = ?;"
        );


        return jdbcUserDetailsManager;

    }





    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers( HttpMethod.GET, "/api/income/incomes").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/income/incomes/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/api/income/addIncome").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/incomemonth/incomemonths").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/incomemonth/incomemonths/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/incomemonth/addIncomeMonth").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/incomemonth/editIncomeMonth").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/incomemonth/deleteIncomeMonth").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/incomemonth/deleteIncomeMonthById/**").hasRole("ADMIN")


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
