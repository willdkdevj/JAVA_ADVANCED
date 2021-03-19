package br.com.supernovatech.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * Programa que avalia a maior palavra e que apresenta mais vezes na frase 
 * a fim de substituí-la pelo seu caracter, correspondente a primeira letra da palavra
 * 
 */
public class Frase6 {	
	
	protected static Map<String, String> mapaPalavras;
	protected static Map<String, Integer> ocorrenciasPalavras;
	
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    String frase;        
    
    while(!".".equals((frase = br.readLine()))){
      StringTokenizer st = new StringTokenizer(frase);      
      mapaPalavras = new TreeMap<>();
      ocorrenciasPalavras = new HashMap<>();
      while(st.hasMoreTokens()){
        String palavra = st.nextToken();
        if(palavra.length() < 3)	continue;
       	ocorrenciasPalavras.put(palavra, ocorrenciasPalavras.containsKey(palavra) ? ocorrenciasPalavras.get(palavra) + 1 : 1);        	
       	mapaPalavras.put(palavra.charAt(0) + ".", verificarPalavras(palavra));
      }    
      // IMPRIME A PALAVRA E A LETRA A QUAL FOI MAPEADA
      imprimirFrase(frase);      
    }
  }
  
  public static String verificarPalavras(String palavra){
	String letraPonto = palavra.charAt(0) + ".";
	if(!mapaPalavras.containsKey(letraPonto))	return palavra;
		  
	// AVALIA A QTD DE VEZES QUE A PALAVRA APARECEU X SEU TAMANHO MENOS DOIS CARACTERES
    int reducaoAtual = ocorrenciasPalavras.get(palavra) * (palavra.length() - 2);
    
	// OBTEM A PALAVRA QUE ESTA ATUALMENTE PARA SER SUBSTITUIDA POR LETRA
  	String atualPalavra = mapaPalavras.get(letraPonto);
  	
  	// AVALIA A QTD DE VEZES QUE A PALAVRA APARECEU X SEU TAMANHO MENOS DOIS CARACTERES
  	int avaliaReducao = ocorrenciasPalavras.get(atualPalavra) * (atualPalavra.length() - 2);        
  	
  	// VERIFICA QUAL OCORRENCIA POSSUI MAIOR RELEVANCIA PARA SER SUBSTITUIDA
  	return avaliaReducao > reducaoAtual ? atualPalavra : palavra;
	  
  }
  
  public static void imprimirFrase(String frase) {
	List<String> listaPalavras = new ArrayList<>();	
	for(String letraPonto : mapaPalavras.keySet()) {
		String palavra = mapaPalavras.get(letraPonto);
		frase = frase.replaceAll("\\b" + palavra + "\\b"," " + letraPonto);
		listaPalavras.add(letraPonto + " = " + palavra);
	}
	System.out.println(frase.trim());
	// APRESENTA A QUANTIDADE DE PALAVRAS QUE FORAM SUBSTITUIDA PELAS LETRAS
  	System.out.println(mapaPalavras.size());
  	listaPalavras.forEach(System.out::println);
  }
}