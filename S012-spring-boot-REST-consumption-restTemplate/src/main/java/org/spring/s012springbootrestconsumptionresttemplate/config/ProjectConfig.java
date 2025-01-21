package org.spring.s012springbootrestconsumptionresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "org.spring.s012springbootrestconsumptionresttemplate.proxy")
public class ProjectConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
