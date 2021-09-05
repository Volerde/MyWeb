package com.volerde.myweb.controller;

import com.volerde.myweb.pojo.Tag;
import com.volerde.myweb.pojo.Type;
import com.volerde.myweb.service.BlogService;
import com.volerde.myweb.service.ClassificationService;
import com.volerde.myweb.service.TagsService;
import com.volerde.myweb.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Volerde
 * @date 2021/9/4 18:49
 */
@Controller
public class TagsShowController {

    @Autowired
    private TagsService tagsService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 10,sort = {"updateDate"},direction = Sort.Direction.DESC) Pageable pageable,
                                 @PathVariable Long id, Model model){

        List<Tag> tags =  tagsService.listTagTop(1000);
        if (id == -1){
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
