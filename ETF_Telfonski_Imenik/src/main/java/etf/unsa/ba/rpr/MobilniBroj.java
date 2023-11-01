package etf.unsa.ba.rpr;

public class MobilniBroj implements TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobMreza, String br){
        mobilnaMreza = mobMreza;
        broj = br;
    }

    @Override
    public String ispisi() {
        Object o = mobilnaMreza;
        return new String("0"+(String)o + "/"+broj);
    }

    @Override
    public int hasCode() {
        return 0;
    }
}
