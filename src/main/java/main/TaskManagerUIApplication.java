package main;

import javafx.application.Application;
import main.ui.TreeviewApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskManagerUIApplication {


    public static void main(String[] args) {

        System.out.println("я в main");Application.launch(TreeviewApplication.class, args);
    }


}