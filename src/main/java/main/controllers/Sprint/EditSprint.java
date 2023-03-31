package main.controllers.Sprint;

import javafx.scene.control.ListView;
import main.model.Sprint;

public class EditSprint {

    public void editSprint(ListView<Sprint> sprintListView) {
        sprintListView.edit(sprintListView.getSelectionModel().getSelectedIndex());
        sprintListView.setOnEditCommit(event -> {
            if (event.getNewValue().getTitle().length() != 0) {
                sprintListView.getItems().set(event.getIndex(),
                        event.getNewValue());
               // sprintRepo.save(event.getNewValue());
            }
        });
    }
}

