module com.example.predavanjegrafkorinterface {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.predavanjegrafkorinterface to javafx.fxml;
    exports com.example.predavanjegrafkorinterface;
}