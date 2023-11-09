package etf.unsa.ba.rpr;
import java.util.Objects;

public class FiksniBroj  extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad1, String broj1){
        grad = grad1;
        broj = broj1;
        if(grad==null) throw new BrojException("Pozivni broj za fiksni telefon nije OK");
    }
    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }
    public String ispisi() {
        if(grad!=null && broj!=null) return grad.getPozivniBroj()+"/"+broj;
        return null;
    }
    @Override
    public int hasCode() {
        return Objects.hash(grad,broj);
    }
}
