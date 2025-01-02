package org.spring.main;

import org.spring.config.ProjectConfiguration;
import org.spring.models.Comment;
import org.spring.proxies.EmailCommentNotificationProxy;
import org.spring.repositories.DBCommentRepository;
import org.spring.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var commentService = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("Hello, World!");
        comment.setAuthor("Aman");
        commentService.publishComment(comment);
/*
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentNotificationProxy, commentRepository);

        var comment = new Comment();
        comment.setText("Hello, World!");
        comment.setAuthor("Aman");

        commentService.publishComment(comment);
*/
    }
}