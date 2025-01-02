package org.spring.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("amanLoves")
public class Lover {
    private String name = "Aman";
    private Chikki chikki;
    /* method-3 : direct autowiring */
//    @Autowired
//    private MakhanMalai makhanMalai;

    /* method-4 : autowiring using constructor */
    private MakhanMalai makhanMalai;
    @Autowired
    public Lover(MakhanMalai makhanMalai, Chikki chikki) {
        this.makhanMalai = makhanMalai;
        this.chikki = chikki;
    }

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
    public MakhanMalai getMakhanMalai() {
        return makhanMalai;
    }
    public void setMakhanMalai(MakhanMalai makhanMalai) {
        this.makhanMalai = makhanMalai;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
