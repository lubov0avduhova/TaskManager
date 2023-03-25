package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.model.Task;
import main.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


@Component
public class MainController implements Initializable {


    @FXML
    private Label aimUser;

    @FXML
    private MenuItem changeTask;

    @FXML
    private MenuItem deleteTask;

    @FXML
    private Hyperlink taskHyberLink;
    @FXML
    private ListView<Task> taskListView;
    private ConfigurableApplicationContext applicationContext;
    //
    private TaskRepo taskRepo;
    private String title;

    private TaskController taskController;


    @Autowired
    public MainController(@Qualifier("taskRepo") TaskRepo taskRepo,
                          ConfigurableApplicationContext applicationContext,
                          TaskController taskController) {
        this.taskRepo = taskRepo;
        this.applicationContext = applicationContext;
        this.taskController=taskController;
    }

    @FXML
    void deleteTask(ActionEvent event) {
        Task temp = taskListView.getSelectionModel().getSelectedItem();
        taskRepo.delete(temp);
        taskListView.getItems().remove(temp);
    }

    @FXML
    public void setTaskWindow(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/task-window.fxml"));
            loader.setControllerFactory(applicationContext::getBean);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            int temp = taskListView.getSelectionModel().getSelectedIndex();
            taskController.setTextFields(taskListView, temp);

            stage.showAndWait();
    }

        public void setMainWindow(ConfigurableApplicationContext context, Stage stage) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/main-window.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskListView.setItems(FXCollections.observableList((taskRepo.findAll())));
    }


}

