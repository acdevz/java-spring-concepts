package org.spring.main;

import org.springframework.stereotype.Component;

@Component("peanutChikki")
public class Chikki {
    private String name = "Peanut Chikki";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
