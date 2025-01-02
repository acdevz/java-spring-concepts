package org.spring.main;

import org.springframework.beans.factory.annotation.Autowired;

public class Lover {
    private String name;
    private Chikki chikki;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Chikki getChikki() {
        return chikki;
    }
    public void setChikki(Chikki chikki) {
        this.chikki = chikki;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
