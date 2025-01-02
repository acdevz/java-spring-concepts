package org.spring.main;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("cashewChikki")
public class Chikki {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        this.name = "Cashew Chikki";
    }
}
