package org.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackageClasses = {
                org.spring.services.CommentService.class,
                org.spring.proxies.EmailCommentNotificationProxy.class,
                org.spring.repositories.DBCommentRepository.class
        }
)
public class ProjectConfiguration {
}
