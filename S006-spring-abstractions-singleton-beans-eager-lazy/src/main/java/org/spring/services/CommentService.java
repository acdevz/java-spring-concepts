package org.spring.services;

import org.spring.models.Comment;
import org.spring.proxies.CommentNotificationProxy;
import org.spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private Comment comment;
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(@Qualifier("push") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
