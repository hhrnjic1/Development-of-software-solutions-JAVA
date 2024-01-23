package ba.unsa.rpr.predavanje;

public class Knjiga {
    private int id;
    private String naslov, autor, isbn;

    public Knjiga() {
    }

    public Knjiga(int id, String naslov, String autor, String isbn) {
        this.id = id;
        this.naslov = naslov;
        this.autor = autor;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
