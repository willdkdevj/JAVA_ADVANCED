import java.io.IOException;
import java.util.Scanner;

public class Classe{
    
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        
        int valorA = leitor.nextInt();
        int valorB = leitor.nextInt();
        
        if (valorA % valorB == 0) {
            System.out.println("Sao Multiplos");
        } else {
            System.out.println("Nao sao Multiplos");
        }
   
    }
    
}
