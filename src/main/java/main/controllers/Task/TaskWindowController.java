package main.controllers.Task;

import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import main.model.Task;
import org.springframework.stereotype.Component;

@Component("taskWindowController")
public class TaskWindowController {

    //возможность изменения названия по двойному клику
    public void initTask(ListView<Task> taskListView) {
        taskListView.setCellFactory(param -> {
            TextFieldListCell<Task> cell = new TextFieldListCell<>();
            cell.setConverter(new StringConverter<>() {
                @Override
                public String toString(Task object) {
                    return object.getTitle();
                }

                @Override
                public Task fromString(String string) {
                    Task task = cell.getItem();
                    task.setTitle(string);
                    return task;
                }
            });
            return cell;
        });
        taskListView.setEditable(true);
    }

    public TaskWindowController() {
    }
}
