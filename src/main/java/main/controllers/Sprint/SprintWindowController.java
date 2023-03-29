package main.controllers.Sprint;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import main.controllers.MainController;
import main.model.Aim;
import main.model.Sprint;
import main.model.Task;
import main.repo.AimRepo;
import main.repo.SprintRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class SprintWindowController {

    @FXML
    protected DatePicker endDate;
    @FXML
    protected DatePicker startDate;
    @FXML
    protected TextField title;
    protected ListView<Sprint> sprintListView;
    protected int temp;
    protected SprintRepo sprintRepo;
    protected Sprint tempSprint;
    private Aim aim;
    private AddSprint addSprint;

    private MainController mainController;
    private AimRepo aimRepo;

    public SprintWindowController(@Qualifier("sprintRepo") SprintRepo sprintRepo,
                                  MainController mainController) {
        this.sprintRepo = sprintRepo;
        this.mainController = mainController;
        addSprint = new AddSprint();
    }

    public SprintWindowController() {
    }

    public void addSprint() throws IOException {
        setSprintWindow("Добавление спринта");
    }

    public void updateSprint() throws IOException {
        setSprintWindow("Изменить спринт");
    }

    public void setSprintFields(ListView<Sprint> sprintListView, int temp) {
        this.sprintListView = sprintListView;
        this.temp = temp;

        if (temp != -1) {
            title.setText(sprintListView.getItems().get(temp).getTitle());
            startDate.setValue(sprintListView.getItems().get(temp).getStartDate());
            endDate.setValue(sprintListView.getItems().get(temp).getEndDate());
        }
    }


    private void updateListView() {
        if (temp != -1) {
            sprintListView.getItems().add(temp, tempSprint);
            sprintListView.getItems().remove(temp + 1);
        } else sprintListView.getItems().add(tempSprint);
    }

    protected void setTempTask() {
        tempSprint.setTitle(title.getText());
        tempSprint.setStartDate(startDate.getValue());
        tempSprint.setEndDate(endDate.getValue());
    }

    @FXML
    public void initialize(Sprint sprint, Aim aim) {
        this.aim = aimRepo.getReferenceById(aim.getId());

        if(sprint != null){
            tempSprint = sprint;
            title.setText(tempSprint.getTitle());
            startDate.setValue(tempSprint.getStartDate());
            endDate.setValue(tempSprint.getEndDate());
        }
    }


    private void setSprintWindow(String title) throws IOException {
        String url = "/UI/sprint-window.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        DialogPane dialogPane = loader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle(title);

        Optional<ButtonType> result = dialog.showAndWait();

        addSprint();

        if (result.isPresent()) {
            if (result.get() == ButtonType.APPLY) {
                if (temp == -1) {
                    tempSprint = new Sprint();

                } else {
                    tempSprint = sprintListView.getItems().get(temp);
                }
                setTempTask();
                updateListView();
                sprintRepo.save(tempSprint);
                dialog.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Отмена");
                alert.setHeaderText("Данные не будут сохранены");
                alert.setContentText("Вы хотите выйти без сохранения?");
                if (alert.showAndWait().get() == ButtonType.OK) {
                    dialog.close();
                } else dialog.show();
            }
        }
    }
}

