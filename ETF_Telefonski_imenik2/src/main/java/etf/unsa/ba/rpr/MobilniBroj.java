package etf.unsa.ba.rpr;
import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobMreza, String br){
        mobilnaMreza = mobMreza;
        broj = br;
    }

    @Override
    public String ispisi() {
        if(broj!=null) return "+"+mobilnaMreza+"/"+broj;
        return null;
    }

    @Override
    public int hasCode() {
        return Objects.hash(mobilnaMreza,broj);
    }
}
