package org.spring.main;

import org.spring.config.ProjectConfig;
import org.spring.models.Comment;
import org.spring.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("Hello, world!");
        comment.setAuthor("Aman Chandra");
        service.publishComment(comment);
        service.deleteComment(comment);
    }
}