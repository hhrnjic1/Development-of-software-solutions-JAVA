package com.example.lab7i8_korisnici;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class KorisniciController {
    public javafx.scene.control.ListView<Korisnik> listView;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldE_mail;
    public TextField fldKorisnickoIme;
    public TextField fldLozinka;

    private KorisniciModel model = new KorisniciModel();

    public KorisniciController(){
        model.napuni();
    }

    @FXML
    public void initialize(){
        listView.setItems(model.getLista());
        model.trenutniKorisnikProperty().addListener(
            (obs,oldKorisnik,newKorisnik)->{
                if(oldKorisnik != null){
                    fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                    fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                    fldE_mail.textProperty().unbindBidirectional(oldKorisnik.e_mailProperty());
                    fldKorisnickoIme.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                    fldLozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
                }
                if(newKorisnik == null){
                    fldIme.setText("");
                    fldPrezime.setText("");
                    fldE_mail.setText("");
                    fldKorisnickoIme.setText("");
                    fldLozinka.setText("");
                }
                else{
                    fldIme.textProperty().bindBidirectional(newKorisnik.imeProperty());
                    fldPrezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                    fldE_mail.textProperty().bindBidirectional(newKorisnik.e_mailProperty());
                    fldKorisnickoIme.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                    fldLozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                }
            }
        );
    }

    public void odabirKorinika(MouseEvent mouseEvent) {
        model.setTrenutniKorisnik(listView.getSelectionModel().getSelectedItem());
    }

    public void dodajKorisnika(ActionEvent actionEvent) {
        Korisnik novi = new Korisnik("Novi","Korisnik","","","");
        model.getLista().add(novi);
        model.setTrenutniKorisnik(novi);
    }

    public void obrisiKorisnika(ActionEvent actionEvent) {
        model.getLista().remove(model.getTrenutniKorisnik());
        model.setTrenutniKorisnik(null);
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}