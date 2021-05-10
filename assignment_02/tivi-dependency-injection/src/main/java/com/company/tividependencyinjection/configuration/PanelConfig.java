package com.company.tividependencyinjection.configuration;

import com.company.tividependencyinjection.beans.Panel;

// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PanelConfig {

    @Bean
    public Panel ledPanel() {
        return new Panel("LED");
    }

    @Bean
    public Panel oledPanel() {
        return new Panel("OLED");
    }
}
