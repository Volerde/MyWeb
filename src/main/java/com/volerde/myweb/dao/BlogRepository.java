package com.volerde.myweb.dao;

import com.volerde.myweb.pojo.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Volerde
 * @date 2021/8/24 17:10
 */
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommendStatus = true")
    List<Blog> findTop(Pageable pageable);

    @Query("select function('date_format',b.updateDate,'%Y') as year from Blog b group by function('date_format',b.updateDate,'%Y') order by function('date_format',b.updateDate,'%Y')")
    List<String> findGroupYear();

    @Query("select b from Blog b where function('date_format',b.updateDate,'%Y') = ?1")
    List<Blog> findByYear(String year);
}
