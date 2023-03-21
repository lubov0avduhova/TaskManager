package main.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import main.TaskManagerUIApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class TreeviewApplication extends Application {
    @Autowired
    private ConfigurableApplicationContext applicationContext;


    public void start(Stage stage) throws IOException {
        applicationContext = SpringApplication.run(TaskManagerUIApplication.class);
        FXMLLoader loader = new FXMLLoader(TaskManagerUIApplication.class.getResource("/UI/main-window.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}




