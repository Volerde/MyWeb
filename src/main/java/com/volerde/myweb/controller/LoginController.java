package com.volerde.myweb.controller;

import com.volerde.myweb.pojo.User;
import com.volerde.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * The type Login controller.
 *
 * @author Volerde
 * @date 2021 /8/16 19:47
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * Login page string.
     *
     * @return the string
     */
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    /**
     * Login string.
     *
     * @param username   the username
     * @param password   the password
     * @param attributes the attributes
     * @param session    the session
     * @return the string
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        RedirectAttributes attributes,
                        HttpSession session){
        User user = userService.checkUser(username, password);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect: /admin";
        }
    }

    /**
     * Logout string.
     *
     * @param session the session
     * @return the string
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
