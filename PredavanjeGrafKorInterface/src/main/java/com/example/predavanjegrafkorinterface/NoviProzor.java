package com.example.predavanjegrafkorinterface;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NoviProzor {

    public Label LabelaNovogProzora;

    public void onButtonZatvoriClick(ActionEvent actionEvent) {
        Stage stage = (Stage) LabelaNovogProzora.getScene().getWindow();
        stage.close();

        /* ILI Kada nema objekata moze ovako
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();*/
    }
}
