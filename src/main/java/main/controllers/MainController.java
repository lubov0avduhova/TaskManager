package main.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import main.controllers.Sprint.DeleteSprint;
import main.controllers.Sprint.SprintWindowController;
import main.controllers.Task.DeleteTask;
import main.controllers.Task.TaskWindowController;
import main.model.Sprint;
import main.model.Task;
import main.repo.SprintRepo;
import main.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@Component(value = "mainController")
public class MainController implements Initializable {
// @FXML
//    private Label aimUser;
//@FXML
//private Hyperlink taskHyberLink;

    @FXML
    protected ListView<Sprint> sprintListView;
    @FXML
    private ListView<Task> taskListView;

    public ListView<Task> getTaskListView() {
        return taskListView;
    }

    protected ConfigurableApplicationContext context;
    protected TaskRepo taskRepo;
    protected SprintRepo sprintRepo;
    protected String title;
    protected SprintWindowController sprintWindowController;

    @Autowired
    public MainController(@Qualifier("taskRepo") TaskRepo taskRepo,
                          @Qualifier("sprintRepo") SprintRepo sprintRepo,
                          ConfigurableApplicationContext context,
                          SprintWindowController sprintWindowController) {
        this.taskRepo = taskRepo;
        this.sprintRepo = sprintRepo;
        this.context = context;
        this.sprintWindowController = sprintWindowController;
        taskListView = new ListView<>();
    }

    public MainController() {
    }

    public ListView<Sprint> getSprintListView() {
        return sprintListView;
    }


    @FXML
    void setSprintWindow(ActionEvent event) throws IOException {
        int temp = sprintListView.getSelectionModel().getSelectedIndex();
        sprintWindowController.setSprintFields(sprintListView, temp);
        sprintWindowController.addSprint();
    }

    @FXML
    void deleteSprint(ActionEvent event) {
        DeleteSprint deleteSprint = new DeleteSprint();
        deleteSprint.deleteSprint(sprintListView, taskListView);
    }


    //изменить спринт по названию
    @FXML
    private void editSprint(MouseEvent mouse) {
//        EditSprint editSprint = new EditSprint();
//        editSprint.editSprint(sprintListView, sprintRepo);
    }


    //блок, где все работает. Не трогать!!!!

    @FXML
    void deleteTask(ActionEvent event) {
        DeleteTask deleteTask = new DeleteTask();
        deleteTask.deleteTask(taskListView, taskRepo);
    }

    @FXML
    public void setTaskWindow(ActionEvent event) throws IOException {
        String url = "/UI/task-window.fxml";
        Stage stage = new Stage();
        FXMLLoader loader = setWindow(stage, url);
        TaskWindowController taskWindowController = loader.getController();
        Sprint temp = sprintListView.getSelectionModel().getSelectedItem();
        if(temp == null){
            temp = sprintListView.getItems().get(0);
        }
        taskWindowController.initialize(taskListView.getSelectionModel().getSelectedItem(), temp);
        stage.showAndWait();
    }

    public void setMainWindow(ConfigurableApplicationContext context, Stage stage) throws IOException {
        String url = "/UI/main-window.fxml";
        setWindow(stage, url);
        stage.show();
    }

    @FXML
    public void setTaskListView(MouseEvent event) {
        Sprint temp = sprintListView.getSelectionModel().getSelectedItem();
       // if (temp.getTaskList() != null) {
            taskListView.getItems().clear();
       // }
        taskListView.getItems().addAll(taskRepo.findAllById(temp.getId()));
    }


    private void initSprint() {

        sprintListView.setCellFactory(param -> {
            TextFieldListCell<Sprint> cell = new TextFieldListCell<Sprint>();
            cell.setConverter(new StringConverter<Sprint>() {
                @Override
                public String toString(Sprint object) {
                    return object.getTitle();
                }

                @Override
                public Sprint fromString(String string) {
                    Sprint sprint = cell.getItem();
                    sprint.setTitle(string);
                    return sprint;
                }
            });
            return cell;
        });
        sprintListView.setEditable(true);

    }

    private FXMLLoader setWindow(Stage stage, String url) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        return loader;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sprintListView.setItems(FXCollections.observableList((sprintRepo.findAll())));
        initSprint();
        Sprint temp = sprintListView.getItems().get(0);
        List tempList = taskRepo.findAllById(temp.getId());
        taskListView.getItems().addAll(tempList);
    }
}




