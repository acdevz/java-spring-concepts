package org.spring.repositories;

import org.spring.models.Comment;

public interface CommentRepository {
    public void storeComment(Comment comment);
}
