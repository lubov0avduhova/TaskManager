package main.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.model.Client;
import main.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexController implements Initializable {

    private final ClientRepo clientRepo;
    private final String title;

    @FXML
    private Label lblTitle;

    @FXML
    private ComboBox<Client> comboClients;

    @FXML
    private DatePicker endDate;
    @FXML
    private DatePicker startDate;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtTitle;

    @FXML
    void onSave(ActionEvent event) {
        Client client = new Client();
        client.setTitle(txtTitle.getText());
        client.setDescription(txtDescription.getText());
        client.setStartDate(startDate.getValue());
        client.setEndDate(endDate.getValue());

        clientRepo.save(client);
        comboClients.setItems(FXCollections.observableArrayList(clientRepo.findAll()));
    }

    public IndexController(@Qualifier("lblTitle") String title,
                           @Qualifier("clientRepo") ClientRepo clientRepo) {
        this.title = title;
        this.clientRepo = clientRepo;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitle.setText(title);

        comboClients.setItems(FXCollections.observableArrayList(clientRepo.findAll()));

    }
}
