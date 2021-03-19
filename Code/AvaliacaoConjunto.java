package br.com.supernovatech.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
	
public class AvaliacaoConjunto {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int numeroPalavras = Integer.valueOf(br.readLine());
	    
	    while(numeroPalavras != 0) {
	    	List<String> listaPalavras = new ArrayList<>();
	    	for(int i = 0; i < numeroPalavras; i++)
	    		listaPalavras.add(br.readLine());	    		    
	    	
	    	listaPalavras = listaPalavras.stream().sorted().collect(Collectors.toList());
	    	
	    	for(int i = 0; i < numeroPalavras -1; i++) {
	    		if(listaPalavras.get(i + 1).startsWith(listaPalavras.get(i))) {
	    			System.out.println("Conjunto Ruim");
	    			break;
	    		}
	    	}
	    	System.out.println("Conjunto Bom");
	    	numeroPalavras = Integer.valueOf(br.readLine());
	    }
	}
}
