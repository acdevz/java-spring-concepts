package org.spring.proxies;

import org.spring.models.Comment;

public interface CommentNotificationProxy {
    public void sendComment(Comment comment);
}
