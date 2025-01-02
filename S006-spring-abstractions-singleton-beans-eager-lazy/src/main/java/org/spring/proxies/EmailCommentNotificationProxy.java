package org.spring.proxies;

import org.spring.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    public void sendComment(Comment comment) {
        System.out.println("Sending Email notification for Comment: " + comment);
    }
}
