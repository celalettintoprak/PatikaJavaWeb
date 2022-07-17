package Java101;//  Patika.dev Java 101 Ödev 17

/*
  Java döngüler ile kullanıcının girdiği sayıya kadar çift olan sayıları bulan programı yazıyoruz.
  Ödev
  Java döngüler ile 0'dan girilen sayıya kadar olan sayılardan 3 ve 4'e tam bölünen sayıların
  ortalamasını hesaplayan programı yazınız.
*/

import java.util.Scanner;

public class Odev17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int yil = scanner.nextInt();
        int[] ciftSayi = new int[(yil / 2) + 1];

        for (int i = 0; i <= yil; i++) {
            if (i % 2 == 0) {
                ciftSayi[i / 2] = i;
            }
        }

        for (int i : ciftSayi) {
            System.out.print(i + " ");
        }
    }
}