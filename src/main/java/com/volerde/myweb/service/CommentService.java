package com.volerde.myweb.service;

import com.volerde.myweb.pojo.Comment;

import java.util.List;

/**
 * @author Volerde
 * @date 2021/9/3 16:38
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
