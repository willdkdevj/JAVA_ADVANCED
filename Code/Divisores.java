import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minhaClasse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//declare suas variaveis
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        br.close();   

        //declare suas variaveis com o valor correto 
        int menorNum = 0;       

//continue o codigo
        if ( C % A == 0 ){
          for(int i =  1; i <= C/A; i++ ){
            int num = A * i;
            if ( num % B != 0 && D % num != 0 && C % num == 0 ){
              menorNum = num;      
              break;
            }         
          }    
        }
        if(menorNum == 0) {
          System.out.println("-1");
        } else {
          System.out.println(menorNum);
        }
    }    
}