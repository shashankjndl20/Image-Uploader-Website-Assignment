package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentManager commentManager;

    public CommentServiceImpl() {
        this.commentManager = new CommentManager();
    }

    @Override
    public Comment getById(int id) {
        return commentManager.getById(id);
    }

    @Override
    public Comment add(Comment comment) {
        return commentManager.add(comment);
    }
}
