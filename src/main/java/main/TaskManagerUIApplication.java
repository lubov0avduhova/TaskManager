package main;

import javafx.application.Application;
import main.model.Prog;
import main.model.Task;
import main.ui.StageInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskManagerUIApplication {

    public static void main(String[] args) {
        Application.launch(StageInitializer.class, args);

        Prog prog = new Task();
    }
}