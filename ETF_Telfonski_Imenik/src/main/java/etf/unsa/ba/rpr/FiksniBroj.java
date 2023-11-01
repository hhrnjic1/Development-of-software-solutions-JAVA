package etf.unsa.ba.rpr;

public class FiksniBroj  extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad1, String broj1){
        grad = grad1;
        broj = broj1;
    }
    public String ispisi() {
        return grad + "/" + broj;
    }
    @Override
    public int hasCode() {
        return 0;
    }
}
