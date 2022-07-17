package Java101;// Patika.dev Java 101 Ödev 7

/*
  Manav Kasa Programı
  Java ile kullanıcıların manavdan almış oldukları ürünlerin
  kilogram değerlerine göre toplam tutarını ekrana yazdıran programı yazın.

  Meyveler ve KG Fiyatları
  Armut : 2,14 TL
  Elma : 3,67 TL
  Domates : 1,11 TL
  Muz: 0,95 TL
  Patlıcan : 5,00 TL

  Örnek Çıktı;
  Armut Kaç Kilo ? :0
  Elma Kaç Kilo ? :1
  Domates Kaç Kilo ? :1
  Muz Kaç Kilo ? :2
  Patlıcan Kaç Kilo ? :3
  Toplam Tutar : 21.68 TL
 */

import java.util.Scanner;

public class Odev07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String decimalFormat = "%.2f";

        String[] meyve = {"Armut", "Elma", "Domates", "Muz", "Patlıcan"};
        float[] fiyat = {(float)(2.14), (float)(3.67), (float)(1.11), (float)(0.95), (float)(5.00)};
        float tutar = 0;

        // int[] miktar = new int[meyve.length];

        for (int i = 0; i < meyve.length; i++) {
            System.out.print(meyve[i] + " kaç kilo? : ");
            tutar += fiyat[i] * input.nextInt();

            // miktar[i] = input.nextInt();
            // tutar += fiyat[i] * miktar[i];
        }

        System.out.println("Toplam Tutar: " + String.format(decimalFormat, tutar) + " TL'dir.");
    }
}