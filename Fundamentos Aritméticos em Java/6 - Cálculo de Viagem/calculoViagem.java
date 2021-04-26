import java.util.Scanner;
public class Main{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
	  
	  Double tempoGasto = scan.nextDouble();
	  Double velocidadeMédia = scan.nextDouble();
	  
	  Double litrosCombustivelGasto = (tempoGasto * velocidadeMédia)/12;
	  
		System.out.printf("%.3f\n", litrosCombustivelGasto);
	}
}
