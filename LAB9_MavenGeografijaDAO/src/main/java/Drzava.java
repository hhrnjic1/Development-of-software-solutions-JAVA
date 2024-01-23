

public class Drzava {
    int id,glavniGradId;
    String naziv;

    public Drzava() {
    }

    public Drzava(int id, int glavniGradId, String naziv) {
        this.id = id;
        this.glavniGradId = glavniGradId;
        this.naziv = naziv;
    }

    public Drzava(Drzava nadjiDrzavu) {
        this.id = nadjiDrzavu.getId();
        this.naziv = nadjiDrzavu.getNaziv();
        this.glavniGradId = nadjiDrzavu.getGlavniGradId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlavniGradId() {
        return glavniGradId;
    }

    public void setGlavniGradId(int glavniGradId) {
        this.glavniGradId = glavniGradId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
