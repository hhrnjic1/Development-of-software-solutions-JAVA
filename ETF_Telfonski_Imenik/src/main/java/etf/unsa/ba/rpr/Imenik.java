package etf.unsa.ba.rpr;
import java.util.*;

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
    public Set<String> izGrada(Grad g){
        Set<String> imena = null;
        TreeSet<String> slozeni = null;
        for(Map.Entry<String,TelefonskiBroj> pretrazivac : imenik.entrySet()){
            String s = pretrazivac.getValue().ispisi();
            String sub = s.substring(0,4);
            if(sub.equals(g)){
                slozeni.add(pretrazivac.getKey());
            }
        }
        imena = slozeni;
        return  imena;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> brojevi = null;
        TreeSet<TelefonskiBroj> slozeni = null;
        for(Map.Entry<String,TelefonskiBroj> pretrazivac : imenik.entrySet()){
            String s = pretrazivac.getValue().ispisi();
            String sub = s.substring(0,4);
            if(sub.equals(g)){
                slozeni.add(pretrazivac.getValue());
            }
        }
        brojevi = slozeni;
        return brojevi;
    }
}
