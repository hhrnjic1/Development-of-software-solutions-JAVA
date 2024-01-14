module com.example.lab6_kalkulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab6_kalkulator to javafx.fxml;
    exports com.example.lab6_kalkulator;
}