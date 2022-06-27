//  Patika.dev Java 101 Ödev 35

/*
  Recursive Metotlar ile Üslü Sayı Hesaplama
  Java dilinde, taban ve üs değerleri kullanıcıdan alınan üs alma işlemini
  "Recursive" metot kullanarak yapan programı yazınız.

  Senaryo
  Taban değeri giriniz :2
  Üs değerini giriniz : 0
  Sonuç : 1
  Taban değeri giriniz : 2
  Üs değerini giriniz : 3
  Sonuç : 8
  Taban değeri giriniz : 5
  Üs değerini giriniz : 3
  Sonuç : 125
*/

import java.util.Scanner;

public class Odev35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Taban sayısı : ");
        int taban = scanner.nextInt();
        System.out.print("Sayının kuvveti : ");
        int us = scanner.nextInt();

        System.out.println(taban + " ^ " + us + " = " + usAlma(taban, us));
    }

    static int sonuc = 1;
    public static int usAlma(int taban, int us) {
        if (taban == 0) {
            return 0;
        } else if (us == 0) {
            return 1;
        }
        sonuc *= taban;
        usAlma(taban, us - 1);
        return sonuc;
    }
}