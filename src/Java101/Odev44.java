package Java101;//  Patika.dev Java 101 Ödev 44

/*
  Bir sayı dizisindeki tekrar eden çift sayıları belirten bir program yazınız.
*/

import java.util.*;

public class Odev44 {
    public static void main(String[] args) {
        int[] sayilar = {1, 2, 3, 0, 7, 12, 15, 28, 12, 788, 1, -1, -778, 2, 12, 2, 0, -778};

        String doubles = findEvenDoubles(sayilar);
        System.out.println("Sıralı Liste : " + Arrays.toString(sort(sayilar)));
        System.out.println("Tekrar Eden Çift Sayılar : " + doubles);
    }

    public static int[] sort(int[] dizi) {
        return Arrays.stream(dizi).sorted().toArray();
    }

    public static String findEvenDoubles(int[] dizi) {
        Collection<String> list = new ArrayList<>();
        int[] sorted = sort(dizi);
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1] && sorted[i] % 2 == 0) {
                list.add(String.valueOf(sorted[i]));
            }
        }
        List<String> doubles = list.stream().distinct().toList();
        return String.valueOf(doubles);
    }
}