package com.company.tividependencyinjection.services;

import com.company.tividependencyinjection.beans.Os;
import com.company.tividependencyinjection.beans.Tivi;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TiviFactory {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${panel}")
    private String panel;

    @Value("${os}")
    private String osTivi;

    @Bean
    public Tivi makeTivi() {

        Os os;

        switch (osTivi) {
            case "IOS":
                os = (Os) applicationContext.getBean("appletivi");
                break;
            case "Tizen":
                os = (Os) applicationContext.getBean("tizentivi");
                break;
            case "Android":
                os = (Os) applicationContext.getBean("androidtivi");
                break;
            default:
                os = (Os) applicationContext.getBean("normalTivi");
                break;
        }

        return new Tivi(os);
    }
}