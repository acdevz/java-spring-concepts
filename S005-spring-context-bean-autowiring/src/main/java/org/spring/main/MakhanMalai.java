package org.spring.main;

import org.springframework.stereotype.Component;

@Component("kesarMakhanMalai")
public class MakhanMalai {
    private String name = "Kesar Makhan Malai";
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
