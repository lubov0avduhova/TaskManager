package main.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.TaskManagerUIApplication;
import main.beans.TaskList;
import main.model.Task;
import main.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
//потом на будущее
//@FXML
//private ListView<?> sprintsList;
    @FXML
    private Label aimUser;
    @FXML
    private DatePicker endDate;
    @FXML
    private DatePicker startDate;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtTitle;

    //сейчас

    @FXML
    private MenuItem changeTask;

    @FXML
    private MenuItem deleteTask;


    private final TaskRepo taskRepo;
    private String title;

    @FXML
    private Hyperlink taskHyberLink;
    @FXML
    private Button addTask;
    private Task task;

    @Autowired
    public MainController(TaskRepo taskRepo,
    ConfigurableApplicationContext applicationContext, Task task) {
        this.taskRepo = taskRepo;
        this.applicationContext = applicationContext;
        this.task = task;

    }

    private ConfigurableApplicationContext applicationContext;

    @FXML
    private ListView<String> taskListView;

    @FXML
    void onSave(ActionEvent event) {
        Task task = new Task();
        task.setTitle(txtTitle.getText());
        task.setDescription(txtDescription.getText());
        task.setStartDate(startDate.getValue());
        task.setEndDate(endDate.getValue());

        taskRepo.save(task);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskListView.getItems().add(String.valueOf(taskHyberLink));
    }

    @FXML
    void addNewTaskWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/task-window.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Add new task");
        stage.setScene(scene);
        stage.show();

    }
}
