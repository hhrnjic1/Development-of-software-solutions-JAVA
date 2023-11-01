package etf.unsa.ba.rpr;
import java.util.HashMap;
import java.util.Map;

public class Imenik {
    HashMap<String,TelefonskiBroj> imenik;

    public void dodaj(String ime , TelefonskiBroj broj){
        imenik.put(ime,broj);
    }
    public String dajBroj(String ime){
        TelefonskiBroj a = imenik.get(ime);
        return a.ispisi();
    }
    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> entry : imenik.entrySet()){
            if(entry.getValue().equals(broj)){
                return entry.getKey();
            }
        }
        return null;
    }
    public String naSlovo(char s){
        String spisak = "";
        Object br = 1;
        for(Map.Entry<String,TelefonskiBroj> pretrazivac : imenik.entrySet()){
            if(pretrazivac.getKey().indexOf(s) == 0){
                spisak += br + ". " + pretrazivac.getKey() + " - " + pretrazivac.getValue().ispisi()+"\n";
            }
        }
        return spisak;
    }
}
