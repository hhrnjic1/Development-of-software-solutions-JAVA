

public class Grad {
    int id, brojStanovnika, drzavaId;
    String naziv;

    public Grad() {
    }

    public Grad(int id, String naziv , int broj_stanovnika, int drzavaid) {
        this.id = id;
        this.brojStanovnika = broj_stanovnika;
        this.drzavaId = drzavaid;
        this.naziv = naziv;
    }

    public Grad(Grad novi) {
        if(novi != null) {
            this.id = novi.getId();
            this.brojStanovnika = novi.getBrojStanovnika();
            this.drzavaId = novi.getDrzavaId();
            this.naziv = novi.getNaziv();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public int getDrzavaId() {
        return drzavaId;
    }

    public void setDrzavaId(int drzavaId) {
        this.drzavaId = drzavaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
