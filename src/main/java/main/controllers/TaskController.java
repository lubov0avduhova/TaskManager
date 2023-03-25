package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.Task;
import main.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class TaskController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField descriptionField;
    @FXML
    private DatePicker endDate;
    @FXML
    private DatePicker startDate;
    @FXML
    private TextField taskField;
    @FXML
    private ListView<Task> taskListView;

    private TaskRepo taskRepo;
    private int temp;
    private Task tempTask;
    private Stage stage;

    @Autowired
    public TaskController(@Qualifier("taskRepo") TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startDate.setValue(LocalDate.now());
    }

    public void setTextFields(ListView<Task> taskListView, int temp) {
        this.taskListView = taskListView;
        this.temp = temp;

        if (temp != -1) {
            taskField.setText(taskListView.getItems().get(temp).getTitle());
            descriptionField.setText(taskListView.getItems().get(temp).getDescription());
            startDate.setValue(taskListView.getItems().get(temp).getStartDate());
            endDate.setValue(taskListView.getItems().get(temp).getEndDate());
        }
    }

    @FXML
    private void onSave() {
        if (temp == -1) {
            tempTask = new Task();
        } else {
            tempTask = taskListView.getItems().get(temp);
        }
        setTempTask();
        updateListView();
        taskRepo.save(tempTask);
        stage = (Stage) startDate.getScene().getWindow();
        stage.close();
    }

    private void updateListView() {
        if (temp != -1) {
            taskListView.getItems().add(temp, tempTask);
            taskListView.getItems().remove(temp + 1);
        } else taskListView.getItems().add(tempTask);
    }

    private void setTempTask() {
        tempTask.setTitle(taskField.getText());
        tempTask.setDescription(descriptionField.getText());
        tempTask.setStartDate(startDate.getValue());
        tempTask.setEndDate(endDate.getValue());
    }
}
