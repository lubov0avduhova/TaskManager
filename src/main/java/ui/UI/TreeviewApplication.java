package ui.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class TreeviewApplication extends Application {
    public static ConfigurableApplicationContext applicationContext;
    public static Parent rootNode;
    public static Stage stage;

    //    private ConfigurableApplicationContext applicationContext;
//
//    @Override
//    public void init() throws Exception {
//        applicationContext = new SpringApplicationBuilder(TaskManagerUIApplication.class).run();
//    }
//
    public void start(Stage stage) throws IOException {
        System.out.println("!!!!");
        applicationContext = SpringApplication.run(TaskManagerUIApplication.class);
        FXMLLoader loader = new FXMLLoader(TaskManagerUIApplication.class.getResource("/hello-view.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(loader.load(), 800, 800, false, SceneAntialiasing.BALANCED);

        stage.setScene(scene);
        stage.show();
    }
}
//
//    static class StageReadyEvent extends ApplicationEvent {
//        public StageReadyEvent(Stage stage) {
//            super(stage);
//        }
//
//        public Stage getStage() {
//            System.out.println("в getStage");
//            return (Stage) getSource();
//        }
//    }
//    @Override
//    public void stop() {
//        System.out.println("в stop");
//        applicationContext.close();
//        Platform.exit();
//    }
//



