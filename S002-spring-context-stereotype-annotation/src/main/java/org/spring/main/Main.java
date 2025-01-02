package org.spring.main;

import org.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Chikki chikki = context.getBean("cashewChikki", Chikki.class);
        System.out.println(chikki.getName());

    }
}