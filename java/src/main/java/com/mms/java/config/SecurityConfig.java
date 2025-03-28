package com.mms.java.config;

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
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
               configurer
                       .requestMatchers(HttpMethod.GET, "/api/pokemon").hasRole("EMPLOYEE")
                       .requestMatchers(HttpMethod.GET, "/api/pokemon/**").hasRole("EMPLOYEE")
                       .requestMatchers(HttpMethod.POST, "/api/pokemon").hasRole("MANAGER")
                       .requestMatchers(HttpMethod.PUT, "/api/pokemon").hasRole("MANAGER")
                       .requestMatchers(HttpMethod.DELETE, "/api/pokemon/**").hasRole("MANAGER")
                );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
