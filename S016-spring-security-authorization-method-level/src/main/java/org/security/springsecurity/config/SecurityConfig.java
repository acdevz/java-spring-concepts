package org.security.springsecurity.config;

import org.security.springsecurity.config.authenticationHandlers.CustomAuthenticationFailureHandler;
import org.security.springsecurity.config.authenticationHandlers.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(c ->{
                    c.successHandler(new CustomAuthenticationSuccessHandler());
                    c.failureHandler(new CustomAuthenticationFailureHandler());
                })
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c -> {
                    c.requestMatchers("/document/**").authenticated();
                    c.requestMatchers(HttpMethod.GET, "/profile").hasAnyRole("USER", "ADMIN");
                    c.requestMatchers(HttpMethod.GET, "/dashboard").hasRole("ADMIN");
                    c.requestMatchers("/product/{code:^[0-9]*$}").permitAll();
                    c.requestMatchers("/email/{email:.*(?:.+@.+\\.com)}").permitAll();
                    c.requestMatchers("/video/{country:^uk|in|ca|us$}/{language:^en|fr|hi$}").permitAll();
                    c.anyRequest()
                        .access(new WebExpressionAuthorizationManager(
                                "hasRole('ADMIN')"
                        ));
                })
                .build();
    }
}
