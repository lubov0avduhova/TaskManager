package main.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.TaskManagerUIApplication;
import main.controllers.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class StageInitializer extends Application {
    @Autowired
    private ConfigurableApplicationContext context;

    private MainController mainController;

    @Override
    public void init() {
        context = SpringApplication.run(TaskManagerUIApplication.class);
        mainController = context.getBean(MainController.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
     mainController.setMainWindow(context, stage);
    }


    @Override
    public void stop() throws Exception {
        context.close();
    }

}


