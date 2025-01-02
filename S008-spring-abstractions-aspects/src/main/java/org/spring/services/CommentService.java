package org.spring.services;

import org.spring.annotations.ToLog;
import org.spring.models.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());
    public String publishComment(Comment comment) {
       logger.info("Comment published: " + comment.getText());
       return "SUCCESS!";
    }
    @ToLog
    public String deleteComment(Comment comment) {
       logger.info("Comment deleted: " + comment.getText());
       return "SUCCESS!";
    }
}
