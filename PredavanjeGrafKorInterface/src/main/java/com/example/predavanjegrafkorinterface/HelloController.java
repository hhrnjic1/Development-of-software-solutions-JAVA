package com.example.predavanjegrafkorinterface;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HelloController {
    public TextField TextFieldKorisnickoIme;
    public TextField TextFieldLozinka;

    @FXML
    public void initialize(){
        TextFieldKorisnickoIme.getStyleClass().add("poljeNijeIspravno");
        TextFieldKorisnickoIme.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(TextFieldKorisnickoIme.getText().trim().isEmpty()){
                    TextFieldKorisnickoIme.getStyleClass().removeAll("poljeJeIspravno");
                    TextFieldKorisnickoIme.getStyleClass().add("poljeNijeIspravno");
                }else {
                    TextFieldKorisnickoIme.getStyleClass().removeAll("poljeNijeIspravno");
                    TextFieldKorisnickoIme.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }

    public void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        if(TextFieldKorisnickoIme.getText().trim().isEmpty()){
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NoviProzor.fxml"));
        Parent root = loader.load();
        NoviProzor noviprozor = loader.getController();
        noviprozor.LabelaNovogProzora.setText(noviprozor.LabelaNovogProzora.getText() + " " + TextFieldKorisnickoIme.getText());
        Stage stage = new Stage();
        stage.setTitle("Novi Prozor");
        Scene scene = new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setScene(scene);
        stage.show();
    }

}