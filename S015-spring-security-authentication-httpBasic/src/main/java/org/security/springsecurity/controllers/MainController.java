package org.security.springsecurity.controllers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.logging.Logger;

@RestController
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String home() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication user = context.getAuthentication();
        return "Welcome, " + user.getName() + "!";
    }

    @GetMapping("/bye")
    @Async
    public void bye(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication user = context.getAuthentication();
        logger.info("bye, " + user.getName() + "!");
    }
}
