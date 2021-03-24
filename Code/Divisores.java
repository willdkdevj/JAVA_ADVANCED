import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minhaClasse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        br.close();   

        int num = 0;

        if (C % A == 0) {
            for(int i = 1; i <= C/A; i++){                
                num = A*i;
                if (num % B != 0 && D % num != 0 && C % num ==0) {
                    if(num == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(num);
                    }
                    break;
                }
            }
        }
                
    }    
}