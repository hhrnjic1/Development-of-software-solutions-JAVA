module ba.unsa.rpr.predavanje.dal_i_mvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.unsa.rpr.predavanje.dal_i_mvc to javafx.fxml;
    exports ba.unsa.rpr.predavanje.dal_i_mvc;
}