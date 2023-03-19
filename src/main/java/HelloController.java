//package main.ui.UI;
//
//import javafx.application.Application;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeView;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//import main.Repository.TaskDAO;
//import main.ServiceEntity.Sprints.Tasks.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class HelloController extends Application{
//
//    @Autowired
//    @FXML
//    private TaskDAO taskDAO;
//    @FXML
//    private TreeView<String> treeView;
//    private TreeItem<String> treeItem;
//
//    @FXML
//    void addSprint(MouseEvent event){
//        List<Task> theTasks = taskDAO.getTasks();
//        treeItem = new TreeItem<>();
//        treeView = new TreeView<>();
//        for (Task task : theTasks) {
//            treeItem.getChildren().add(new TreeItem<>(task.getTitle()));
//        }
//        treeView.setRoot(treeItem);
//        treeView.setShowRoot(true);
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        stage.setTitle("Hello!");
//        stage.setScene(new Scene(root));
//        stage.show();
//    }
//
//
////
////

//    private TreeItem<String> treeItem;
//    private TreeItem<String> root = new TreeItem<>("корневой элемент");
//    private TreeItem<String> sprints;
//    private String sprint = "Спринт ";
//    private int i;
//    @FXML
//    private TextArea textField;
//
//    @FXML
//    void addSprint(MouseEvent event) {
//        root.setExpanded(true);
//        sprints = new TreeItem<>(sprint + i);
//        root.getChildren().add(sprints);
//        i++;
//        treeView.setRoot(root);
//        treeView.setShowRoot(true);
//    }
//
//    @FXML
//    void addTreeItem(MouseEvent event) {
//        int i = treeView.getSelectionModel().getSelectedIndex();
//        treeView.getTreeItem(i).getChildren().add(new TreeItem<>(textField.getText()));
////    }
//}


