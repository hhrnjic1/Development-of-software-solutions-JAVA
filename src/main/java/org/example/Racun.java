package org.example;

public class Racun {
    private long brojRacuna;
    private Osoba korisnik;
    public Racun(Long l,Osoba o){

    }
    public boolean provjeriOdobrenjePrekorcenja(double prekoracenje){
        return true;
    }
    public boolean izvrsiUplatu(double uplata){
        return true;
    }
    public boolean izvrsiIsplatu(double isplata){
        return true;
    }
    public long brojRacuna(){
        return this.brojRacuna;
    }
    public Osoba korisnikRacuna(){
        return this.korisnik;
    }
    public boolean odobrenjePrekoracenja(){
        return true;
    }
    public double stanjeRacuna(){
        return this.brojRacuna;
    }
}
