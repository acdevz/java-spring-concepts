package org.spring.config;

import org.spring.main.Chikki;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean( name = "peanutChikki" )
    @Primary
    Chikki peanutChikki(){
        Chikki peanutChikki = new Chikki();
        peanutChikki.setName("Peanut Chikki");
        return peanutChikki;
    }

    @Bean( name = "cashewChikki" )
    Chikki cashewChikki(){
        Chikki cashewChikki = new Chikki();
        cashewChikki.setName("Cashew Chikki");
        return cashewChikki;
    }

    @Bean
    String hello(){
        return "Hello World";
    }
}
