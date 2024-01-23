package com.example.lab7i8_korisnici;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> lista = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Korisnik> lista) {
        this.lista = lista;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void napuni(){
        lista.add(new Korisnik("Hamza","Hrnjic","hhrnjic1@etf.unsa.ba","hhrnjic1","hamza123"));
        lista.add(new Korisnik("Denan","Poturak","dpoturak1@etf.unsa.ba","dpoturak1","denan123"));
        lista.add(new Korisnik("Vedran","Ljubovic","vljubovic1@etf.unsa.ba","vljubovic1","veca123"));
        trenutniKorisnik.set(null);
    }
}
