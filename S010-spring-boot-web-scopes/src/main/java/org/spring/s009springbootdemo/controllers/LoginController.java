package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.processors.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }
    @GetMapping("/login")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if(!loggedIn) {
            return "login.html";
        }
        model.addAttribute("message", "You are logged in");
        return "redirect:/";
    }
}
