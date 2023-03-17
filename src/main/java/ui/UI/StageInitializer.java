package ui.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ui.UI.TreeviewApplication.StageReadyEvent;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:hello-view.fxml")
    private Resource treeviewResorce;


    private ApplicationContext applicationContext;

    public StageInitializer(@Value("Demo title")String applicationTitle,
                            ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    private String applicationTitle;

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(treeviewResorce.getURL());
        fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
        Parent parent = fxmlLoader.load();
        Stage stage = event.getStage();
        stage.setScene(new Scene(parent, 800, 600));
        stage.setTitle(applicationTitle);
        stage.show();
    }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}