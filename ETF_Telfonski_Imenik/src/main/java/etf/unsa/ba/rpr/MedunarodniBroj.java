package etf.unsa.ba.rpr;
import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;

    MedunarodniBroj(String drzava, String broj){
        this.drzava = drzava;
        this.broj = broj;
    }
    @Override
    public String ispisi() {
        if(drzava!=null && broj!=null) return drzava+broj;
        return null;
    }

    @Override
    public int hasCode() {
        return Objects.hash(drzava,broj);
    }
}
