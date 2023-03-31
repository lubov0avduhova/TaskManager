package main.controllers.Sprint;

import javafx.scene.control.ListView;
import main.model.Sprint;
import main.model.Task;
//import main.repo.SprintRepo;

public class DeleteSprint {

    public void deleteSprint(ListView<Sprint> sprintListView) {
        Sprint sprint = sprintListView.getSelectionModel().getSelectedItem();

       // sprintRepo.deleteById(sprint.getId());
        sprintListView.getItems().remove(sprint);
    }
}
