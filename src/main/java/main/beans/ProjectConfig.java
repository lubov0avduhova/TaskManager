package main.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean(name = "lblTitle")
    String getTitle() {
        return "Spring and JavaFX";
    }

}
