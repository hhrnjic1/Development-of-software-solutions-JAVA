module com.example.lab7i8_korisnici {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab7i8_korisnici to javafx.fxml;
    exports com.example.lab7i8_korisnici;
}