package com.example.predispitnavjezbamvc;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class HelloController {
    private Model model = new Model();

    public ChoiceBox choiceBox;
    public TextField fldAutor;
    public TextField fldNaslov;
    public TextField fldIsbn;

    public HelloController(){
    }
    @FXML
    public void initialize(){
        choiceBox.setItems(model.getKnjige());

        model.trenutnaKnjigaProperty().addListener(
                (obs,oldValue,newValue) -> {
                    Knjiga oldKnjiga = (Knjiga) oldValue;
                    Knjiga newKnjiga = (Knjiga) newValue;
                    if(oldValue != null){
                        fldAutor.textProperty().unbindBidirectional(oldKnjiga.autorProperty());
                        fldNaslov.textProperty().unbindBidirectional(oldKnjiga.naslovProperty());
                        fldIsbn.textProperty().unbindBidirectional(oldKnjiga.isbnProperty());
                    }
                    if(newValue != null){
                        fldAutor.textProperty().bindBidirectional(newKnjiga.autorProperty());
                        fldNaslov.textProperty().bindBidirectional(newKnjiga.naslovProperty());
                        fldIsbn.textProperty().bindBidirectional(newKnjiga.isbnProperty(), new NumberStringConverter());
                    }
                    else{
                        fldAutor.setText("");
                    }
                }
        );
    }

    public void promjenaKnjige(ActionEvent actionEvent) {

        model.setTrenutnaKnjiga((Knjiga)choiceBox.getValue());
    }

    public void ispisiSveKnjige(ActionEvent actionEvent) {
        System.out.println(model.getKnjige().toString());
    }
}