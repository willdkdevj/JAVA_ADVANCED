package br.com.supernovatech.test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidandoSenhas {
	public final static int MAX = 200;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String senha;
		
		while((senha = br.readLine()) != null){
		  boolean contemNumero = false;
		  boolean contemMaiuscula = false;
		  boolean contemMinuscula = false;
		  boolean tamanhoSenha = senha.length() >= 6 && senha.length() <= 32;
		  boolean contemPontuacao = senha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
		  
		  for(int i = 0; i < senha.length(); i++){
		    if(Character.isDigit(senha.charAt(i))){
		      contemNumero = true;
		    } else if(Character.isUpperCase(senha.charAt(i))){
		      contemMaiuscula = true;
		    } else if(Character.isLowerCase(senha.charAt(i))){
		      contemMinuscula = true;
		    }
		  }
		  
		  if(tamanhoSenha && contemPontuacao && contemNumero && contemMinuscula && contemMaiuscula){
		    System.out.println("Senha valida.");
		  } else {
		    System.out.println("Senha invalida.");
		  }
		}
	}
}

