package ba.unsa.rpr.predavanje;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static KnjigaDAO dao;
    private static  Scanner ulaz;

    public static void main(String[] args) throws SQLException {

        dao = KnjigaDAO.getInstance();
        ulaz = new Scanner(System.in);

        int opcija = 0;
        do {
            System.out.println("Unesite opciju:\n1 - pretraga\n2 - unos\n 3 - izmjena\n4 - brisanje\n0 - KRAJ!");
            opcija = ulaz.nextInt();
            if(ulaz.hasNextLine()) ulaz.nextLine();
            switch (opcija){
                case 1:
                    pretraga();
                    break;
                case 2:
                    unos();
                    break;
                case 3:
                    izmjena();
                    break;
                case 4:
                    brisanje();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }

        }while(opcija != 0);
    }

    private static void brisanje() {
        int id;
        System.out.println("Unesite id knjige koju brisete: ");
        id = ulaz.nextInt();
        dao.brisi   (id);
    }

    private static void izmjena() {
        String naslov,autor,isbn;
        int id;
        System.out.println("Unesite id knjige koju mijenjate: ");
        id = ulaz.nextInt();
        if(ulaz.hasNextLine()) ulaz.nextLine();
        System.out.println("Unesite naslov: ");
        naslov = ulaz.nextLine();

        System.out.println("Unesite autora: ");
        autor = ulaz.nextLine();

        System.out.println("Unesite isbn: ");
        isbn = ulaz.nextLine();

        Knjiga k = new Knjiga(id,naslov,autor,isbn);
        dao.izmjeni(k);

    }

    private static void unos() throws SQLException {
        String naslov,autor,isbn;
        System.out.println("Unesite naslov: ");
        naslov = ulaz.nextLine();

        System.out.println("Unesite autora: ");
        autor = ulaz.nextLine();
        System.out.println("Unesite isbn: ");
        isbn = ulaz.nextLine();

        Knjiga k = new Knjiga(0,naslov,autor,isbn);
        dao.dodaj(k);
    }

    private static void pretraga() throws SQLException {
        System.out.println("Unesite naslov knjige ili autora: ");
        String uneseni = ulaz.nextLine();

        for( Knjiga x : dao.pretraga(uneseni))
            System.out.println(x.getAutor() + " " + x.getNaslov());

        dao.removeInstance();
    }
}
