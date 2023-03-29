package main.controllers.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.controllers.MainController;
import main.model.Sprint;
import main.model.Task;
import main.repo.SprintRepo;
import main.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("taskWindowController")
public class TaskWindowController {
    @FXML
    protected TextField descriptionField;
    @FXML
    protected DatePicker endDate;
    @FXML
    protected DatePicker startDate;
    @FXML
    protected TextField taskField;

    protected TaskRepo taskRepo;

    protected Task tempTask;
    protected Stage stage;
    protected MainController mainController;

    private Sprint sprint;
    private SprintRepo sprintRepo;

    @Autowired
    public TaskWindowController(@Qualifier("taskRepo") TaskRepo taskRepo, MainController mainController,
                                @Qualifier("sprintRepo") SprintRepo sprintRepo) {
        this.taskRepo = taskRepo;
        this.mainController = mainController;
        this.sprintRepo = sprintRepo;

    }

    public TaskWindowController() {
    }





    @FXML
    protected void onSave() {

        if (tempTask == null) {
            tempTask = new Task();
        }
        setTempTask();
        updateListView();

        tempTask.setSprint(sprint);
        taskRepo.save(tempTask);

        stage = (Stage) startDate.getScene().getWindow();
        stage.close();

    }

    @FXML
    protected void onCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Отмена");
        alert.setHeaderText("Данные не будут сохранены");
        alert.setContentText("Вы хотите выйти без сохранения?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) startDate.getScene().getWindow();
            stage.close();
        }
    }

    protected void updateListView() {
        if (mainController.getTaskListView().getItems().contains(tempTask)) {
            int temp = mainController.getTaskListView().getItems().indexOf(tempTask);
            mainController.getTaskListView().getItems().set(temp, tempTask);

        } else {
            mainController.getTaskListView().getItems().add(tempTask);
        }
    }

    protected void setTempTask() {
        tempTask.setTitle(taskField.getText());
        tempTask.setDescription(descriptionField.getText());
        tempTask.setStartDate(startDate.getValue());
        tempTask.setEndDate(endDate.getValue());
    }
    @FXML
    public void initialize(Task task, Sprint sprint){
        this.sprint = sprintRepo.getReferenceById(sprint.getId());

        if(task != null){
            tempTask = task;
            taskField.setText(tempTask.getTitle());
            descriptionField.setText(tempTask.getDescription());
            startDate.setValue(tempTask.getStartDate());
            endDate.setValue(tempTask.getEndDate());
        }
    }

}
