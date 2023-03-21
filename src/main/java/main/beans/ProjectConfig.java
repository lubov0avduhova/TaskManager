package main.beans;

import main.TaskManagerUIApplication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ProjectConfig {
//    private ConfigurableApplicationContext applicationContext;
//
//    public ConfigurableApplicationContext getApplicationContext() {
//        return applicationContext;
//    }

    @Bean(name = "lblTitle")
    String getTitle() {
        return "Spring and JavaFX";
    }

}
