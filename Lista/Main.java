package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static double mean(ArrayList<Double> lista){
        double devijacija = 0;
        for(Double x: lista){
            devijacija += x;
        }
        return devijacija/ lista.size();
    }
    private static double standardna(ArrayList<Double> lista){
        double mean = mean(lista);
        double varijacija = 0;
        for (double x : lista){
            varijacija += Math.pow(x-mean,2);
        }
        return Math.sqrt(1/ (lista.size()-1) * varijacija );
    }
    private static double max(ArrayList<Double> lista){
        double max = Double.MIN_VALUE;
        for(double x : lista){
            if(x > max) max = x;
        }
        return max;
    }
    private static double min(ArrayList<Double> lista){
        double min = Double.MAX_VALUE;
        for(double x : lista){
            if(x < min) min= x;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Double> lista = new ArrayList<Double>();
        Double a = 0.0;
        while(!in.hasNext("stop")) {
            System.out.println("Unesite element liste: ");
            if (in.hasNextDouble()) {
                a = in.nextDouble();
                lista.add(a);
            }
            else {
                in.next();
            }
        }
        System.out.println("Devijacije su:");
        System.out.println("Mean: "+ mean((ArrayList)lista));
        System.out.println("Standardna: "+ standardna((ArrayList)lista));
        System.out.println("Max: "+ max((ArrayList)lista));
        System.out.println("Min: "+ min((ArrayList)lista));
    }
}
