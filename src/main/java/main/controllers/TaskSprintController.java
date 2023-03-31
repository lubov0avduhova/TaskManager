package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
import java.util.ResourceBundle;

@Component
public class TaskSprintController implements Initializable {
    @FXML
    public TextField titleField;
    @FXML
    public TextField descriptionField;
    @FXML
    public DatePicker endDate;
    @FXML
    public DatePicker startDate;

    //-----------------------------------------------


    private Prog childTemp;

    public void setChildTemp(Prog childTemp) {
        this.childTemp = childTemp;
    }

    public void setParentTemp(Prog parentTemp) {
        this.parentTemp = parentTemp;
    }

    private Dialog<ButtonType> dialog;

    public Dialog getDialog() {
        return dialog;
    }

    public Prog getChildTemp() {
        return childTemp;
    }

    private Prog parentTemp;
    private MainRepo mainRepo;


    protected ConfigurableApplicationContext context;
    //-----------------------------------------------------------

    @Autowired
    public TaskSprintController(ConfigurableApplicationContext context,
                                @Qualifier("mainRepo") MainRepo mainRepo) {
        this.context = context;
        this.mainRepo = mainRepo;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleField.setText(childTemp.getTitle());
        descriptionField.setText(childTemp.getDescription());
        startDate.setValue(childTemp.getStartDate());
        endDate.setValue(childTemp.getEndDate());
    }

    private void setTempObject() {
        childTemp.setTitle(titleField.getText());
        childTemp.setDescription(descriptionField.getText());
        childTemp.setStartDate(startDate.getValue());
        childTemp.setEndDate(endDate.getValue());

    }

    public void setWindow() throws IOException {
        String url = "/UI/sprint-window.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        loader.setControllerFactory(context::getBean);
        dialog = new Dialog<>();
        dialog.setDialogPane(loader.load());

        dialog.showAndWait().ifPresent(response -> {
            if (response == ButtonType.APPLY) {
                if (childTemp instanceof Task) {
                    setTempObject();
                    ((Task) childTemp).setSprint((Sprint) parentTemp);
                    mainRepo.save(childTemp);
                }
            } else {
                onCancel();
            }
        });
    }


    @FXML
    protected void onCancel() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Отмена");
        alert.setHeaderText("Данные не будут сохранены");
        alert.setContentText("Вы хотите выйти без сохранения?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) startDate.getScene().getWindow();
            stage.close();
        }
    }
}