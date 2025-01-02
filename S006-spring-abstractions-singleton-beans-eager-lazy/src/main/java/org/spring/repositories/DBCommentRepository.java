package org.spring.repositories;

import org.spring.models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {
    public void storeComment(Comment comment) {
        System.out.println("Storing Comment: " + comment);
    }
}
