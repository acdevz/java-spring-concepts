package org.security.springsecurity.config;

import org.security.springsecurity.config.authenticationHandlers.CustomAuthenticationFailureHandler;
import org.security.springsecurity.config.authenticationHandlers.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(c ->{
//                    c.defaultSuccessUrl("/home", true);
                    c.successHandler(new CustomAuthenticationSuccessHandler());
                    c.failureHandler(new CustomAuthenticationFailureHandler());
                })
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(c ->
                        c.anyRequest().authenticated())
                .build();
    }
}
