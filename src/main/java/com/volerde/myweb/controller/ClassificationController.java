package com.volerde.myweb.controller;

import com.volerde.myweb.pojo.Type;
import com.volerde.myweb.service.ClassificationService;
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
 * @date 2021/8/19 11:47
 */
@Controller
@RequestMapping("/admin")
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/classification")
    public String classification(@PageableDefault(size = 10,direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        model.addAttribute("page",classificationService.listType(pageable));
        return "admin/classification_manage";
    }

    @GetMapping("/classification/input")
    public String input(){
        return "admin/classification_input";
    }

    @GetMapping("/classification/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",classificationService.getType(id));
        return "admin/classification_input";
    }

    @PostMapping("/classification")
    public String post(@Valid Type type, RedirectAttributes attributes){
        Type type1 = classificationService.getTypeByName(type.getName());
        if(type1 != null){
            attributes.addFlashAttribute("message","该分类已存在");
            return "admin/classification_input";
        }else {
            classificationService.saveType(type);
            return "redirect:/admin/classification";
        }
    }

    @PostMapping("/classification/{id}")
    public String editPost(@Valid Type type,@PathVariable Long id, RedirectAttributes attributes){
        Type type1 = classificationService.getTypeByName(type.getName());
        if(type1 != null){
            attributes.addFlashAttribute("message","该分类已存在");
            return "admin/classification_input";
        }else {
            classificationService.updateType(id,type);
            return "redirect:/admin/classification";
        }
    }

    @GetMapping("/classification/{id}/delete")
    public String delete(@PathVariable Long id){
        classificationService.deleteType(id);
        return "redirect:/admin/classification";
    }
}
