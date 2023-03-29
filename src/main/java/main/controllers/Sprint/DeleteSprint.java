package main.controllers.Sprint;

import javafx.scene.control.ListView;
import main.model.Sprint;
import main.model.Task;

public class DeleteSprint {

    public void deleteSprint(ListView<Sprint> sprintListView, ListView<Task> taskListView) {
        Sprint sprint = sprintListView.getSelectionModel().getSelectedItem();

//        aim.getAimDB().remove(sprint);
        sprintListView.getItems().remove(sprint);
        taskListView.getItems().clear();
    }
}
