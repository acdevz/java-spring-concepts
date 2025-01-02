package org.spring.config;

import org.spring.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.spring")
@EnableAspectJAutoProxy
public class ProjectConfig {
}
