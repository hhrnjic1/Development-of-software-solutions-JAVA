package com.example.predispitnavjezbamvc;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private ObservableList<Knjiga> lista = FXCollections.observableArrayList();
    private ObjectProperty<Knjiga> trenutnaKnjiga = new SimpleObjectProperty<>();

    public Model(){
        lista.add(new Knjiga("C i C++ Programiranje", "Vedran Ljubovic", 123123));
        lista.add(new Knjiga("Svijet se raspada", "Chinua Achebe", 123456));
        lista.add(new Knjiga("Božanstvena komedija", "Dante Alighieri", 123321));
    }

    public ObjectProperty<Knjiga> trenutnaKnjigaProperty(){
        return trenutnaKnjiga;
    }
    public Knjiga getTrenutnaKnjiga(){
        return trenutnaKnjiga.get();
    }
    public void setTrenutnaKnjiga(Knjiga k){
        trenutnaKnjiga.set(k);
    }
    public ObservableList<Knjiga> getKnjige(){
        return lista;
    }
}
