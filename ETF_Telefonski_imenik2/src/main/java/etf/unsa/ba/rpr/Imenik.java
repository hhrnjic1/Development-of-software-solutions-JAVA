package etf.unsa.ba.rpr;
import java.util.*;

public class Imenik {
    Map<String,TelefonskiBroj> imenik;

    public Imenik()
    {
        this.imenik=new HashMap<String,TelefonskiBroj>();
    }
    public void setBrojevi(Map<String, TelefonskiBroj> brojevi) {
        this.imenik = brojevi;
    }
    public void dodaj(String ime , TelefonskiBroj broj){
        imenik.put(ime,broj);
    }
    public String dajBroj(String ime)
    {
        TelefonskiBroj broj = this.imenik.get(ime);
        if (broj != null) {
            return broj.ispisi();
        } else {
            return null;
        }
    }
    public String dajIme(TelefonskiBroj broj){
        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            if (entry.getValue().ispisi().equals(broj.ispisi())) {
                return entry.getKey();
            }
        }
        return null;
    }
    public String naSlovo(char s){
        StringBuilder builder = new StringBuilder();

        int counter = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            if (entry.getKey().startsWith(String.valueOf(s))) {
                builder.append(counter) // use string builder to avoid memory overload
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            }
            counter++;
        }
        return builder.toString();
    }
    public Set<String> izGrada(Grad g){
        Set<String> results = new TreeSet<String>(); // tree set impl should sort automatically
        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            if (jelIzGrada(entry.getValue(), g)) {
                results.add(entry.getKey());
            }
        }
        return results;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> results = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });

        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            if (jelIzGrada(entry.getValue(), g)) {
                results.add(entry.getValue());
            }
        }
        return results;
    }

    private boolean jelIzGrada(TelefonskiBroj broj, Grad g) {
        if (broj instanceof FiksniBroj) {
            return g.equals(((FiksniBroj) broj).getGrad());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : this.imenik.entrySet()) {
            builder.append(counter) // use string builder to avoid memory overload
                    .append(". ")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue().ispisi())
                    .append(System.lineSeparator());
            counter++;
        }
        return builder.toString();
    }

}
