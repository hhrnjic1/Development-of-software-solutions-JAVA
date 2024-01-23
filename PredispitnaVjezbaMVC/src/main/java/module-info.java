module com.example.predispitnavjezbamvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.predispitnavjezbamvc to javafx.fxml;
    exports com.example.predispitnavjezbamvc;
}