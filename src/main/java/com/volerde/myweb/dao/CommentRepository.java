package com.volerde.myweb.dao;

import com.volerde.myweb.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Volerde
 * @date 2021/9/3 16:42
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(long blogId, Sort sort);
}
