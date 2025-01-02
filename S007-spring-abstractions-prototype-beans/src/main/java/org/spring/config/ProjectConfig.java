package org.spring.config;

import org.spring.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.spring.main")
public class ProjectConfig {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    CommentService commentService(){
        return new CommentService();
    }

    @Bean
    String hello(){
        return "Hello World";
    }
}
