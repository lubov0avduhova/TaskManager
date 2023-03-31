package main.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.controllers.Sprint.SprintWindowController;
import main.controllers.Task.TaskWindowController;
import main.model.Aim;
import main.model.Prog;
import main.model.Sprint;
import main.model.Task;
import main.repo.MainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
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

    //  protected SprintRepo sprintRepo;
    protected String title;
    protected SprintWindowController sprintWindowController;
    private AimController aimController;

    private MainRepo mainRepo;
//    private Prog aim;
//    private Prog sprint;
//    private Prog task;

    private TaskWindowController taskWindowController;
    private TaskSprintController taskSprintController;

    @Autowired
    public MainController(ConfigurableApplicationContext context,
                          SprintWindowController sprintWindowController,
                          TaskWindowController taskWindowController,
                          AimController aimController,
                          @Qualifier("mainRepo") MainRepo mainRepo,
                          TaskSprintController taskSprintController) {
        //this.sprintRepo = sprintRepo;
        this.context = context;
        this.sprintWindowController = sprintWindowController;
        this.taskWindowController = taskWindowController;
        //  taskListView = new ListView<>();
        this.aimController = aimController;
        this.mainRepo = mainRepo;
        this.taskSprintController = taskSprintController;
//        this.aim = aim;
//        this.sprint = sprint;
//        this.task = task;
    }

    public MainController() {
    }

    public ListView<Sprint> getSprintListView() {
        return sprintListView;
    }


    //изменить спринт по названию
    @FXML
    private void editSprint(MouseEvent mouse) throws IOException {
        // sprintWindowController.addSprint();
    }

    @FXML
    void deleteSprint(ActionEvent event) {
        //     DeleteSprint deleteSprint = new DeleteSprint();
        //   deleteSprint.deleteSprint(sprintListView, sprintRepo);
    }

    @FXML
    void setSprintWindow(ActionEvent event) throws IOException {
        Sprint sprint = sprintListView.getSelectionModel().getSelectedItem();
        Aim aim = new Aim();
      //  taskSprintController.setWindow(sprint, aim);//с aim могут быть проблемы!
    }

    @FXML
    public void setTaskWindow(ActionEvent event) throws IOException {
        Sprint sprint = sprintListView.getSelectionModel().getSelectedItem();
        Task task = taskListView.getSelectionModel().getSelectedItem();


        taskSprintController.setParentTemp((sprint == null)
                ? sprintListView.getItems().get(0) : sprint);
        taskSprintController.setChildTemp((task == null) ? new Task() : task);


        taskSprintController.setWindow();

        if (taskListView.getItems().contains(taskSprintController.getChildTemp())) {
            int temp = taskListView.getItems().indexOf(taskSprintController.getChildTemp());
            taskListView.getItems().set(temp, (Task) taskSprintController.getChildTemp());
            System.out.println("я в майне - обновляю задачу в список");
            for (Task task1: taskListView.getItems()) {
                System.out.println(task1.getTitle());
            }

        } else {

            taskListView.getItems().add((Task) taskSprintController.getChildTemp());
        }
        taskSprintController.getDialog().close();
    }


    @FXML
    void deleteTask(ActionEvent event) {
        Task task = taskListView.getSelectionModel().getSelectedItem();

        mainRepo.deleteById(task.getId());
        taskListView.getItems().remove(task);
    }


    //работает!

    public void setMainWindow(ConfigurableApplicationContext context, Stage stage) throws IOException {
        String url = "/UI/main-window.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        loader.setControllerFactory(context::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void setTaskListView(MouseEvent event) {
        Sprint temp = sprintListView.getSelectionModel().getSelectedItem();
        if (temp != null) {
            taskListView.getItems().clear();
        }
        taskListView.getItems().addAll(mainRepo.findAllTasks(temp.getId()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sprintListView.setItems(FXCollections.observableList((mainRepo.findAllSprints())));
        Prog temp = sprintListView.getItems().get(0);
        List tempList = mainRepo.findAllTasks(temp.getId());
        taskListView.getItems().addAll(tempList);

        sprintWindowController.initSprint(sprintListView);
        taskWindowController.initTask(taskListView);
    }
}




