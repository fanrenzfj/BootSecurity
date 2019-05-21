package com.steczs.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    // Login form
    @RequestMapping("/login.html")
    public String login() {
        System.out.println("login.html");
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
    @RequestMapping("/zd")
    public ModelAndView loginError() {
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }
}
