package org.spring.proxies;

import org.spring.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("push")
public class CommentPushNotificationProxy implements CommentNotificationProxy {
    public void sendComment(Comment comment) {
        System.out.println("Sending Push notification for Comment: " + comment);
    }
}
