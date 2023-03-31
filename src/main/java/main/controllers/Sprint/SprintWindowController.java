package main.controllers.Sprint;

import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import main.model.Sprint;
import org.springframework.stereotype.Component;

@Component
public class SprintWindowController {

    //возможность изменения названия по двойному клику
    public void initSprint(ListView<Sprint> sprintListView) {
        sprintListView.setCellFactory(param -> {
            TextFieldListCell<Sprint> cell = new TextFieldListCell<>();
            cell.setConverter(new StringConverter<>() {
                @Override
                public String toString(Sprint object) {
                    return object.getTitle();
                }

                @Override
                public Sprint fromString(String string) {
                    Sprint sprint = cell.getItem();
                    sprint.setTitle(string);
                    return sprint;
                }
            });
            return cell;
        });
        sprintListView.setEditable(true);
    }
}


