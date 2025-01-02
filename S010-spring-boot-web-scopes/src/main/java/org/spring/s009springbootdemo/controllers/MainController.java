package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.services.LoggedUserManagementService;
import org.spring.s009springbootdemo.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/")
    public String main(Model model) {
        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        model.addAttribute("loginCount", loginCountService.getCount());
        return "home.html";
    }

    @GetMapping("/logout")
    public String logout() {
        loggedUserManagementService.setUsername(null);
        return "redirect:/login";
    }
}
