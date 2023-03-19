package main;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import main.ui.TreeviewApplication;


@SpringBootApplication
public class TaskManagerUIApplication{


    public static void main(String[] args) {
        Application.launch(TreeviewApplication.class, args);
    }


}