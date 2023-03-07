module petproject.petproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens petproject.petproject to javafx.fxml;
    exports petproject.petproject;
}