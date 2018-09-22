package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Comment;

public interface CommentService {
    Comment getById(int id);

    Comment add(Comment comment);
}
