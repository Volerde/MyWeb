package com.volerde.myweb.controller;

import com.volerde.myweb.pojo.Tag;
import com.volerde.myweb.pojo.Type;
import com.volerde.myweb.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Volerde
 * @date 2021/8/22 21:20
 */
@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10,direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        model.addAttribute("page",tagsService.listTag(pageable));
        return "admin/tags_manage";
    }

    @GetMapping("/tags/input")
    public String input(){
        return "admin/tags_input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",tagsService.getTag(id));
        return "admin/tags_input";
    }

    @PostMapping("/tags")
    public String post(@Valid Tag tag, RedirectAttributes attributes){
        Tag tag1 = tagsService.getTagByName(tag.getName());
        if(tag1 != null){
            attributes.addFlashAttribute("message","该标签已存在");
            return "admin/tags_input";
        }else {
            tagsService.saveTag(tag);
            return "redirect:/admin/tags";
        }
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag,@PathVariable Long id, RedirectAttributes attributes){
        Tag tag1 = tagsService.getTagByName(tag.getName());
        if(tag1 != null){
            attributes.addFlashAttribute("message","该标签已存在");
            return "admin/tags_input";
        }else {
            tagsService.updateTag(id,tag);
            return "redirect:/admin/tags";
        }
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id){
        tagsService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
