package.etf.unsa.ba
import java.util.Scanner;
import java.util.Math;

public class Main{

private static long faktorijel(int x){
	long faktorijel = 1;
	for(int i=2; i<= x; i++){
		faktorijel *= i;
	return faktorijel;
}

private class double sinus(double x, int n){
	int predznak = 1;
	double sinus = 0;
	for( int i = 1; i<= 2*n-1; i+=2){
		sinus = sinus + (predznak * Math.pow(x,i)) / faktorijel(i);
		predznak = -predznak;
	}
	return sinus;
}
	
     public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Unesite x: ");
	in.Nextint();
	System.out.println("Unesite n: ");
	in.Nextint();
	System.out.println("Faktorijel od x: "+ faktorijel(x));
	System.out.println("Sinus od x: "+ sinus(x,n));
}
