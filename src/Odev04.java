// Patika.dev Java 101 Ödev 4

/*
  Taksimetre Programı
  Java ile gidilen mesafeye (KM) göre taksimetre tutarını ekrana yazdıran programı yazın.

  Taksimetre KM başına 2.20 TL tutmaktadır.
  Minimum ödenecek tutar 20 TL'dir. 20 TL altında ki ücretlerde yine 20 TL alınacaktır.
  Taksimetre açılış ücreti 10 TL'dir.
 */

import java.util.Scanner;

public class Odev04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen bir mesafe giriniz: ");

        int mesafe = input.nextInt();
        int acilis = 10;
        float birimFiyat = (float) 2.2;
        float tutar = acilis + (mesafe * birimFiyat);

        float odeme = (tutar < 20) ? 20 : tutar;
        System.out.println("Toplam Tutar: " + odeme + " TL'dir.");

        /*
        if (tutar < 20) {
            System.out.println("Toplam Tutar: 20.0 TL'dir.");
        } else {
            System.out.println("Toplam Tutar: " + tutar + " TL'dir.");
        }
         */

    }
}