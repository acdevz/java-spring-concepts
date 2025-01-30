package org.security.springsecurity.config;

import org.security.springsecurity.config.filters.AuthenticationLoggingFilter;
import org.security.springsecurity.config.filters.RequestValidationFilter;
import org.security.springsecurity.config.filters.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.List;

@Configuration
public class SecurityConfig {
    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    @Autowired
    public SecurityConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter) {
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        List<UserDetails> users = List.of(
                User.withUsername("acdevs")
                        .password(passwordEncoder.encode("4444"))
                        .roles("USER")
                        .authorities("read")
                        .build(),
                User.withUsername("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles("ADMIN")
                        .authorities("read", "write")
                        .build()
        );
        return new SimpleUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SimplePasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults()) // default Basic Authentication
                .addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(c ->
                        c.anyRequest().permitAll())
                .build();
    }
}
