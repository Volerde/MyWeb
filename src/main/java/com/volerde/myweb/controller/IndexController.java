package com.volerde.myweb.controller;

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

/**
 * The type Index controller.
 *
 * @author Volerde
 * @date 2021 /8/15 12:50
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private TagsService tagsService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 10,sort = {"updateDate"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("classification",classificationService.listTypeTop(4));
        model.addAttribute("tags",tagsService.listTagTop(6));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(4));
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }
}
