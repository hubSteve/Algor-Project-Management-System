package com.algor.codepool.mvc.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndexHtml() {
        return "index";
    }

    @PostMapping("/login")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/menu/{menuName}")
    public String toMenu(@PathVariable String menuName) {
        menuName = menuName.replace("|", "/");
        return menuName;
    }

    @GetMapping("/projectManagement")
    public String toProjectManagement() {
        return "/pro/ProjectManagement";
    }

    @GetMapping("/home")
    public String toHome() {
        return "/pro/Home";
    }
}
