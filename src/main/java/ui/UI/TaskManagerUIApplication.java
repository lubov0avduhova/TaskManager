package ui.UI;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TaskManagerUIApplication{


    public static void main(String[] args) {
        Application.launch(TreeviewApplication.class, args);
    }


}