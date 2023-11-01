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
                System.out.println("037/"+broj);
                break;
            case ORAŠJE:
                System.out.println("031/"+broj);
                break;
            case TUZLA:
                System.out.println("035/"+broj);
                break;
            case ZENICA:
                System.out.println("032/"+broj);
                break;
            case GORAŽDE:
                System.out.println("038/"+broj);
                break;
            case TRAVNIK:
                System.out.println("030/"+broj);
                break;
            case MOSTAR:
                System.out.println("036/"+broj);
                break;
            case ŠIROKI_BRIJEG:
                System.out.println("039/"+broj);
                break;
            case SARAJEVO:
                System.out.println("033/"+broj);
                break;
            case LIVNO:
                System.out.println("034/"+broj);
                break;
            case BRČKO:
                System.out.println("049/"+broj);
                break;
            default:
                System.out.println("Pogresan grad pri unosu!!!");
        }
        return null;
    }
    @Override
    public int hasCode() {
        return 0;
    }
}
