package etf.unsa.ba.rpr;

public enum Grad {
    TRAVNIK("030"),
    ODZAK("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    POSUSJE("039"),
    BRCKO("049"),
    MRKONJIC_GRAD("050"),
    BANJA_LUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    SAMAC("054"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    FOCA("058"),
    TREBINJE("059");

    private String pozivniBroj;

    /** Konstruktor enumeratora */
    Grad(String pozivniBroj)
    {
        this.pozivniBroj=pozivniBroj;
    }

    /** Geter enumeratora */
    public String getPozivniBroj() {
        return pozivniBroj;
    }

    /** Utiliti metoda za dobivanje konstante na osnovu prosljedenog broja */
    public static Grad izPozivnog(String pozivni)
    {
        for(Grad g:Grad.values())
            if(g.getPozivniBroj().equals(pozivni)){ return g; }
        return null;
    }

}

