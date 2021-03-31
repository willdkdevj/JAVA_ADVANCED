package NumerosRepetidos;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContagemNumerosRepetidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        Locale.setDefault(new Locale("en", "US"));

//declare as variaveis corretamente e continue a sua solução

        ArrayList<Integer> numbersList = new ArrayList<Integer>();

        int entryNumber = sc.nextInt();
        while(entryNumber --> 0)
            numbersList.add(sc.nextInt());

        SortedMap<Integer, Integer> countingNumbers = new TreeMap<>();
        numbersList.forEach(id -> countingNumbers.compute(id, ( key, val) -> (val == null ? 1 : val + 1)));


        countingNumbers.entrySet().forEach(entry->{
            System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
        });

        sc.close();
    }
}
