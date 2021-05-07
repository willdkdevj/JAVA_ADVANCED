import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPalavrasPorTamanho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int linhas = Integer.parseInt(br.readLine());
    
        List<String> listaPalavras = new ArrayList<>();
        
        for (int i = 0; i < linhas; i++) {
            var palavras = br.readLine();
            listaPalavras.addAll(Arrays.stream(palavras.split(" ")).collect(Collectors.toList()));
            var listaOrdenada = listaPalavras.stream()
                .sorted(Comparator.comparingInt(String::length).reversed()
                .thenComparing(String::compareTo)).collect(Collectors.joining(" "));
    
            System.out.println(listaOrdenada);
            listaPalavras.clear();
        }
    }
}