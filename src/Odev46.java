//  Patika.dev Java 101 Ödev 46

/*
  Dizideki elemanların frekanslarını (kaç kez tekrar ettiğini) bulan program yazınız.

  Senaryo
  Dizi : [10, 20, 20, 10, 10, 20, 5, 20]
  Tekrar Sayıları
  10 sayısı 3 kere tekrar edildi.
  20 sayısı 4 kere tekrar edildi.
  5 sayısı 1 kere tekrar edildi.
*/

import java.util.*;

public class Odev46 {
    public static void main(String[] args) {
        int[] sayilar = {1, 2, 3, 0, 7, 12, 15, 28, 12, 788, 1, -1, -778, 2, 12, 2, 0, -778};

        frequency(sayilar);
    }

    public static void frequency(int[] dizi) {
        List<Integer> list = Arrays.stream(dizi).sorted().boxed().toList();
        List<Integer> distinctList = Arrays.stream(dizi).sorted().distinct().boxed().toList();

        int[] freq = new int[distinctList.size()];
        int i = 0;
        for (int j : distinctList) {
            freq[i] = Collections.frequency(list, j);
            i++;
        }
        i = 0;

        System.out.println("Dizi : " + list);
        System.out.println("Dizi elemanlerı : " + distinctList);
        System.out.println("Tekrar Sayıları");
        for (int j : freq) {
            System.out.println(distinctList.get(i) + " sayısı " + j + " kere tekrar edildi.");
            i++;
        }
    }
}