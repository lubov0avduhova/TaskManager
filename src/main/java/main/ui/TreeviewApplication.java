package main.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import main.TaskManagerUIApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class TreeviewApplication extends Application {
    public static ConfigurableApplicationContext applicationContext;
    public static Parent rootNode;
    public static Stage stage;

    public void start(Stage stage) throws IOException {
        applicationContext = SpringApplication.run(TaskManagerUIApplication.class);
        FXMLLoader loader = new FXMLLoader(TaskManagerUIApplication.class.getResource("/UI/test.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(loader.load(), 800, 800, false, SceneAntialiasing.BALANCED);

        stage.setScene(scene);
        stage.show();
    }
}




