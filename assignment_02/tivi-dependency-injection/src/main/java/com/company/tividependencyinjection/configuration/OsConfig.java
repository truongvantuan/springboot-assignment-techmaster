package com.company.tividependencyinjection.configuration;

import com.company.tividependencyinjection.beans.Os;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OsConfig {

    @Bean
    public Os normalTivi() {
        return new Os("Tivi thường");
    }

    @Bean(name = "appletivi")
    public Os appleTivi() {
        return new Os("Hệ điều hành iOs");
    }

    @Bean(name = "androidtivi")
    public Os androidTivi() {
        return new Os("Hệ điều hành Android");
    }

    @Bean(name = "tizentivi")
    public Os samsungTivi() {
        return new Os("Hệ điều hành Tizen");
    }
}
