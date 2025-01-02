package org.spring.main;

import org.springframework.stereotype.Component;

@Component("cashewChikki")
public class Chikki {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
