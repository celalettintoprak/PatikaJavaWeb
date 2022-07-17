package Java101;//  Patika.dev Java 101 Ödev 45

/*
  Java dilinde, dizideki elemanları küçükten büyüğe sıralayan programı yazınız.
  Dizinin boyutunu ve dizinin elemanlarını kullanıcıdan alınız.

  Senaryo
  Dizinin boyutu n : 5
  Dizinin elemanlarını giriniz :
  1. Elemanı : 99
  2. Elemanı : -2
  3. Elemanı : -2121
  4. Elemanı : 1
  5. Elemanı : 0
  Sıralama : -2121 -2 0 1 99
*/

import java.util.*;

public class Odev45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dizinin boyutu n : ");
        int diziBoyutu = scanner.nextInt();
        int[] dizi = new int[diziBoyutu];

        System.out.println("Dizinin elemanlarını giriniz :");
        for (int i = 0; i < diziBoyutu; i++) {
            System.out.print((i + 1) + ". Elemanı : ");
            dizi[i] = scanner.nextInt();
        }

        System.out.println("Sıralama : " + Arrays.toString(sort(dizi)));
    }

    public static int[] sort(int[] dizi) {
        return Arrays.stream(dizi).sorted().toArray();
    }
}