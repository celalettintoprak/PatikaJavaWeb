//  Patika.dev Java 101 Ödev 26

/*
  Java ile klavyeden girilen N tane sayma sayısından en büyük ve
  en küçük sayıları bulan ve bu sayıları ekrana yazan programı yazın.

  Senaryo
  Kaç tane sayı gireceksiniz: 4
  1. Sayıyı giriniz: 16
  2. Sayıyı giriniz: -22
  3. Sayıyı giriniz: -15
  4. Sayıyı giriniz: 100
  En büyük sayı: 100
  En küçük sayı: -22
*/

import java.util.Arrays;
import java.util.Scanner;

public class Odev27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz? : ");
        int sayi = scanner.nextInt();
        int[] dizi = new int[sayi];

        int i = 0;
        while (i != sayi) {
            System.out.print(i + ". sayıyı giriniz : ");
            dizi[i] = scanner.nextInt();
            i++;
        }

        System.out.println("En küçük sayı: " + Arrays.stream(dizi).min().getAsInt());
        System.out.println("En büyük sayı: " + Arrays.stream(dizi).max().getAsInt());
    }
}