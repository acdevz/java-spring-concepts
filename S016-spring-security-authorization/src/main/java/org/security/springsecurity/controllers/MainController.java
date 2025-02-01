package org.security.springsecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.logging.Logger;

@RestController
public class MainController {
    private final Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/profile")
    public String getProfile(
            Authentication user
    ) {
        logger.info(user.getName() + " : authorized to access /profile : " + new Date());
        return "Welcome, " + user.getName() + "!";
    }

    @GetMapping("/dashboard")
    public String getDashboard(
            Authentication user
    ) {
        logger.info(user.getName() + " : authorized to access /dashboard : " + new Date());
        return "Welcome, " + user.getName() + "!";
    }

    @GetMapping("/product/{code}")
    public String getProduct(@PathVariable String code){
        return code;
    }

    @GetMapping("/video/{country}/{language}")
    public String videoController(
            @PathVariable String country,
            @PathVariable String language
    ){
        return "Video allowed for " + country + " in " + language;
    }

    @GetMapping("/email/{email}")
    public String emailController(@PathVariable String email){
        return "Allowed for email " + email;
    }

}
