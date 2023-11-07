package etf.unsa.ba.rpr;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Imenik imenik = null;
        Grad grad1 = Grad.SARAJEVO;
        Grad grad2 = Grad.ZENICA;
        Grad grad3 = Grad.TUZLA;
        imenik.dodaj("Hamza Hrnjic",new FiksniBroj(grad1,"700-378"));
        imenik.dodaj("Ibro Hrnjic",new FiksniBroj(grad1,"700-377"));
        imenik.dodaj("Amna Hodzic",new FiksniBroj(grad2,"700-376"));
        imenik.dodaj("Elvedin Sehic",new FiksniBroj(grad3,"700-378"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(grad1);
        for (TelefonskiBroj x : set){
            System.out.println(x.ispisi());
        }
    }
}
