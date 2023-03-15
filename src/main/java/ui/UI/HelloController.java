package main.UI;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private TreeView<String> treeView;
    private TreeItem<String> treeItem;
    private TreeItem<String> root = new TreeItem<>("корневой элемент");
    private TreeItem<String> sprints;
    private String sprint = "Спринт ";
    private int i;
    @FXML
    private TextArea textField;

    @FXML
    void addSprint(MouseEvent event) {
        root.setExpanded(true);
        sprints = new TreeItem<>(sprint + i);
        root.getChildren().add(sprints);
        i++;
        treeView.setRoot(root);
        treeView.setShowRoot(true);
    }

    @FXML
    void addTreeItem(MouseEvent event) {
        int i = treeView.getSelectionModel().getSelectedIndex();
        treeView.getTreeItem(i).getChildren().add(new TreeItem<>(textField.getText()));
    }
}


