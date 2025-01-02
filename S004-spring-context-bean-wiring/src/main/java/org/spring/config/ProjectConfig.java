package org.spring.config;

import org.spring.main.Chikki;
import org.spring.main.Lover;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.spring.main")
public class ProjectConfig {
    @Bean(name="peanutChikki")
    @Primary
    Chikki peanutChikki(){
        Chikki peanutChikki = new Chikki();
        peanutChikki.setName("Peanut Chikki");
        return peanutChikki;
    }

    @Bean(name="cashewChikki")
    Chikki cashewChikki(){
        Chikki cashewChikki = new Chikki();
        cashewChikki.setName("Cashew Chikki");
        return cashewChikki;
    }

    @Bean(name="amanLoves")
    Lover lover(
            @Qualifier("peanutChikki") Chikki peanutChikki){
        Lover lover = new Lover();
        lover.setName("Aman");
//        lover.setChikki(peanutChikki()); // method-1 : wiring
        lover.setChikki(peanutChikki); // method-2 : wiring
        return lover;
    }


    @Bean
    String hello(){
        return "Hello World";
    }
}
