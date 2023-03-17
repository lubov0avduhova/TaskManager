package ui.UI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class TreeviewApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        applicationContext = new SpringApplicationBuilder(TaskManagerUIApplication.class).run();
    }

    public void start(Stage stage) {
        System.out.println("в start");
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            System.out.println("в getStage");
            return (Stage) getSource();
        }
    }
    @Override
    public void stop() {
        System.out.println("в stop");
        applicationContext.close();
        Platform.exit();
    }



}
