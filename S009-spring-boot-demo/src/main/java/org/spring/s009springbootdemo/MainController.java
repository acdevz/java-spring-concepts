package org.spring.s009springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/{username}")
    public String home(
            @RequestParam(required = false) String color,
            @PathVariable String username,
            Model page) {
        page.addAttribute("username", username);
        page.addAttribute("color", color == null ? "green" : color);
        return "home.html";
    }
}
