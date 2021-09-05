package com.volerde.myweb.controller;

import com.volerde.myweb.pojo.Type;
import com.volerde.myweb.service.BlogService;
import com.volerde.myweb.service.ClassificationService;
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
public class ClassificationShowController {

    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/classification/{id}")
    public String classification(@PageableDefault(size = 10,sort = {"updateDate"},direction = Sort.Direction.DESC) Pageable pageable,
                                 @PathVariable Long id, Model model){

        List<Type> classification =  classificationService.listTypeTop(1000);
        if (id == -1){
            id = classification.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",classification);
        model.addAttribute("page",blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "classification";
    }
}
