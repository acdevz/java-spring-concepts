package org.spring.main;

import org.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Lover lover = context.getBean(Lover.class);
        Chikki chikki = context.getBean(Chikki.class);
        System.out.println(
                "Lover's name: " + lover.getName());
        System.out.println(
                "Chikki name: " + chikki.getName());
        System.out.println(
               lover + " loves " + (lover.getChikki() != null ? lover.getChikki().toString() : "nothing")
        );


    }
}