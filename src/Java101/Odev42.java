package Java101;//  Patika.dev Java 101 Ödev 42

/*
  Dizideki Elemanların Max ve Min Değerlerini Bulan Program

  Ödev
  Dizideki elemanlardan; girilen sayıdan küçük ve büyük en yakın sayıları bulunuz.

  Dizi : {15,12,788,1,-1,-778,2,0}
  Girilen Sayı : 5
  Girilen sayıdan küçük en yakın sayı : 2
  Girilen sayıdan büyük en yakın sayı : 12
*/

import java.util.Arrays;
import java.util.Scanner;

public class Odev42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int[] sayilar = {15, 12, 788, 1, -1, -778, 2, 0};
        input = scanner.nextInt();
        System.out.println(findValues(sayilar, input));
    }

    public static int[] sort(int[] dizi) {
        return Arrays.stream(dizi).sorted().toArray();
    }

    public static int[] reverse(int[] dizi) {
        int[] sorted = sort(dizi);
        int length = sorted.length;
        int[] reverse = new int[length];
        for (int i = length, j = 0; i > 0; i--, j++) {
            reverse[j] = sorted[i - 1];
        }
        return reverse;
    }

    public static String findValues(int[] dizi, int value) {
        int min = 0, max = 0;
        String result;
        for (int i : sort(dizi)) {
            if (i >= value) {
                break;
            }
            min = i;
        }

        for (int i : reverse(sort(dizi))) {
            if (i <= value) {
                break;
            }
            max = i;
        }
        result = "Girilen Sayı : " + value + "\n" +
                "Girilen sayıdan küçük en yakın sayı : " + min + "\n" +
                "Girilen sayıdan büyük en yakın sayı : " + max;
        return result;
    }
}
