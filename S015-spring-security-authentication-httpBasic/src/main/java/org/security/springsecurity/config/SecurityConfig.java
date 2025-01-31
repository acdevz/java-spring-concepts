package org.security.springsecurity.config;

import org.security.springsecurity.config.authenticaionProvider.CustomAuthenticationProvider;
import org.security.springsecurity.config.authenticationFailure.CustomAuthenticationEntryPoint;
import org.security.springsecurity.config.filters.AuthenticationLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.List;

@Configuration
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(c -> {
                    c.realmName("Read it loud.");
                    c.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
                })
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(c ->
                        c.anyRequest().authenticated())
                .build();
    }
}
