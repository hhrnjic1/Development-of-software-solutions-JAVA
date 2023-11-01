package etf.unsa.ba.rpr;
enum Grad{BIHAĆ,ORAŠJE,TUZLA,ZENICA,GORAŽDE,TRAVNIK,MOSTAR,ŠIROKI_BRIJEG,SARAJEVO,LIVNO,BRČKO};
public class FiksniBroj  implements TelefonskiBroj {
    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad1, String broj1){
        grad = grad1;
        broj = broj1;
    }
    public String ispisi() {
        switch (grad) {
            case BIHAĆ:
                return new String("037/"+broj);
            case ORAŠJE:
                return new String("031/"+broj);
            case TUZLA:
                return new String("035/"+broj);
            case ZENICA:
                return new String("032/"+broj);
            case GORAŽDE:
                return new String("038/"+broj);
            case TRAVNIK:
                return new String("030/"+broj);
            case MOSTAR:
                return new String("036/"+broj);
            case ŠIROKI_BRIJEG:
                return new String("039/"+broj);
            case SARAJEVO:
                return new String("033/"+broj);
            case LIVNO:
                return new String("034/"+broj);
            case BRČKO:
                return new String("049/"+broj);
            default:
                return new String("Pogrijesili ste pri unosu grada!!");
        }
    }
    @Override
    public int hasCode() {
        return 0;
    }
}
