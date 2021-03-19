package br.com.supernovatech.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MaiorSubstring {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    
	public static void main(String[] args) throws IOException {
		String text1, text2, menor, maior; //declare suas variaveis aqui
        while ((text1 = in.readLine()) != null) { // complete seu código
            text2 = in.readLine();
            if (text1.length() > text2.length()) {  
               maior = text1;
               menor = text2;
            } else {
               maior = text2;
               menor = text1;
            }
            int minLength = menor.length();
            int maxS = minLength;
            boolean f = true;
            while (maxS > 0 && f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= diff; i++) { //complete o laco de repeticao
                    if (maior.contains(menor.substring(i, i + maxS))) {
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }

}