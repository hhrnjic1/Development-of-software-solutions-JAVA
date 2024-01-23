package ba.unsa.rpr.predavanje.dal_i_mvc;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class KnjigaController {

    private static KnjigaDAO dao;
    public ListView<Knjiga> listKnjige;
    public TextField fldNaslov;
    public TextField fldAutor;
    public TextField fldISBN;

    @FXML
    public void initialize() throws SQLException {
        dao = KnjigaDAO.getInstance();
        listKnjige.setItems(dao.sveKnjige());
        listKnjige.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldItem,newItem) ->{
                    Knjiga oldKnjiga = (Knjiga) oldItem;
                    Knjiga newKnjiga = (Knjiga) newItem;
                    if(oldItem != null){
                        fldNaslov.textProperty().unbindBidirectional(oldKnjiga.naslovProperty());
                        fldAutor.textProperty().unbindBidirectional(oldKnjiga.autorProperty());
                        fldISBN.textProperty().unbindBidirectional(oldKnjiga.isbnProperty());
                        //Mjenja stanje u bazi prilikom promjene na listi
                        dao.izmjeni(oldKnjiga);
                    }
                    if(newItem != null){
                        fldNaslov.textProperty().bindBidirectional(newKnjiga.naslovProperty());
                        fldAutor.textProperty().bindBidirectional(newKnjiga.autorProperty());
                        fldISBN.textProperty().bindBidirectional(newKnjiga.isbnProperty());
                    }else{
                        fldNaslov.setText("");
                        fldAutor.setText("");
                        fldISBN.setText("");
                    }
                }
        );
    }

    public void exitClick(ActionEvent actionEvent) {
        //Platform.exit();
        System.exit(0);
    }

    public void izmjenaClick(ActionEvent actionEvent) {
        for(Knjiga k : listKnjige.getItems()){
                dao.izmjeni(k);
        }
        System.out.println("Azurirana baza!");
    }
}