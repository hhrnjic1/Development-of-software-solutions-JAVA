package com.example.predispitnavjezbamvc;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Knjiga {
    SimpleStringProperty naslov,autor;
    SimpleIntegerProperty isbn;

    public Knjiga(){
        naslov = new SimpleStringProperty();
        autor = new SimpleStringProperty();
        isbn = new SimpleIntegerProperty();
    }
    public Knjiga(String naziv, String autor, int isbn){
        this.naslov = new SimpleStringProperty(naziv);
        this.autor = new SimpleStringProperty(autor);
        this.isbn  = new SimpleIntegerProperty(isbn);
    }

    public void setNaslov(String naziv){
        this.naslov.set(naziv);
    }
    public void setAutor(String autor){
        this.autor.set(autor);
    }
    public void setIsbn(int isbn){
        this.isbn.set(isbn);
    }

    public String getNaslov(){
        return naslov.get();
    }
    public String getAutor(){
        return autor.get();
    }
    public int getIsbn(){
        return isbn.get();
    }

    public SimpleStringProperty naslovProperty(){
        return naslov;
    }
    public SimpleStringProperty autorProperty(){
        return autor;
    }
    public SimpleIntegerProperty isbnProperty(){
        return isbn;
    }

    @Override
    public String toString(){
        return getNaslov() + " " + getAutor() + " " + getIsbn() + "\n";
    }
}
