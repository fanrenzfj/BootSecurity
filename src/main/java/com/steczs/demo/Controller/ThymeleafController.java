package com.steczs.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeleafController {
    @RequestMapping("/zs")
    public String getTest(){
        System.out.println("zs");
        return "user/index";
    }
    @RequestMapping("/zss")
    public String getTest1(){
        System.out.println("zss");
        return "book/list";
    }
}
