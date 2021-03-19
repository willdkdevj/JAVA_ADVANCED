package br.com.supernovatech.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrevistaEmbaracosa {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String palavra;
	    
        while((palavra = br.readLine()) != null) {
            boolean houveRepeticao = false;
            for(int i=0; i < palavra.length(); i++) {
                if( palavra.substring(0, i).endsWith(palavra.substring(i)) ) {
                    System.out.println(palavra.substring(0, i));
                    houveRepeticao = true;
                }
            }
            if(!houveRepeticao) 
              System.out.println(palavra);
        }
    }
}
