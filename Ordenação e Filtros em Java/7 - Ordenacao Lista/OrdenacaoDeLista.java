package ordenacaoLista;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenacaoDeLista {
    public static void main(String[] args) {
        String[] array = {"abc", "2", "10", "0"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    }
}
