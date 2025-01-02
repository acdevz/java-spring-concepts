package org.spring.main;

import org.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        context.registerBean(
                "cashewChikki",
                Chikki.class,
                () -> {
                    Chikki chikki = new Chikki();
                    chikki.setName("Cashew Chikki");
                    return chikki;
                },
                bd -> bd.setPrimary(true));

        Chikki chikki = context.getBean("cashewChikki", Chikki.class);
        System.out.println(chikki.getName());
    }
}