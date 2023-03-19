package main.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    @Bean(name = "lblTitle")
    private String getTitle(){
        return "Spring and JavaFX";
    }
}
