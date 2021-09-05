package com.volerde.myweb.dao;

import com.volerde.myweb.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Volerde
 * @date 2021/8/22 21:25
 */
public interface TagsRepository extends JpaRepository<Tag,Long> {
    Tag getTagByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
