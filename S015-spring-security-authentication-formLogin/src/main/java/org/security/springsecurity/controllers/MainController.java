package org.security.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {
    private final Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/home")
    public String home() {
        logger.info("Served request with home.html");
        return "home.html";
    }
}
