package etf.unsa.ba.rpr;

public enum Grad {
    SARAJEVO("033"), TUZLA("032"), ZENICA("034"), LIVNO("034"), MOSTAR("036"), BIHAC("037");
    private String grad;
    Grad(String grad){
        this.grad = grad;
    }
    @Override
    public String toString(){
        return grad;
    }
}

