package org.security.springsecurity.config.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class StaticKeyAuthenticationFilter extends OncePerRequestFilter {
    private final Logger logger = Logger.getLogger(StaticKeyAuthenticationFilter.class.getName());
    @Value("${authorization.key}")
    private String authorizationKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authentication = request.getHeader("Authorization");
        if (authorizationKey.equals(authentication)) {
            filterChain.doFilter(request, response);
            logger.info("Successfully authenticated static key: " + authorizationKey);
        }
        else {
            response.setStatus( HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
