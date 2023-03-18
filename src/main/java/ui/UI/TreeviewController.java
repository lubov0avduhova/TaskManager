package ui.UI;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import main.Repository.TaskDAO;
import org.springframework.stereotype.Controller;

@Controller
public class TreeviewController {


    private TaskDAO taskDAO;
    @FXML
    private TreeView<String> treeView;
    private TreeItem<String> treeItem;


    @FXML
    public void showTasks(MouseEvent mouseEvent) {
        System.out.println("я в контроллере!");
//        TaskDAO dao = new TaskDAOImpl();
//        List<Task> theTasks = dao.getTasks();
//        treeItem = new TreeItem<>();
//        treeView = new TreeView<>();
//        for (Task task : theTasks) {
//            treeItem.getChildren().add(new TreeItem<>(task.getTitle()));
//        }
//        treeView.setRoot(treeItem);
//        treeView.setShowRoot(true);
    }
}
