package main.controllers.Task;

import javafx.scene.control.ListView;
import main.model.Sprint;
import main.model.Task;
import main.repo.SprintRepo;
import main.repo.TaskRepo;

public class DeleteTask {
    public void deleteTask(ListView<Task> taskListView, TaskRepo taskRepo) {
        Task task = taskListView.getSelectionModel().getSelectedItem();

        taskRepo.deleteById(task.getId());
        taskListView.getItems().remove(task);

    }
}
