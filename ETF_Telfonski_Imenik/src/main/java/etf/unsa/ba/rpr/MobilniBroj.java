package etf.unsa.ba.rpr;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobMreza, String br){
        mobilnaMreza = mobMreza;
        broj = br;
    }

    @Override
    public String ispisi() {
        return
    }

    @Override
    public int hasCode() {
        return 0;
    }
}
