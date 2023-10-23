package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Osoba {
    private String ime;
    private String prezime;
    public Osoba(String ime, String prezime){
        ime = ime;
        prezime = prezime;
    }
    public String ToString(){
        String s1 = ime;
        String s2 = prezime;
        String s3 = ime + prezime;
        return s3;
    }
    public static void main(String[] args) {

        }
    }
