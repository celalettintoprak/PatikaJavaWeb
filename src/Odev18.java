//  Patika.dev Java 101 Ödev 18

/*
  Java döngüler ile negatif bir değer girilene kadar kullanıcıdan girişleri kabul eden ve
  girilen değerlerden tek sayıları toplayıp ekrana basan programı yazıyoruz.
  Ödev
  Java döngüler ile tek bir sayı girilene kadar kullanıcıdan girişleri kabul eden ve
  girilen değerlerden çift ve 4'ün katları olan sayıları toplayıp ekrana basan programı yazıyoruz.
*/

import java.util.Scanner;

public class Odev18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sayi, toplamTek = 0, toplamCift = 0;

        while (true) {
            System.out.print("Bir sayı giriniz : ");
            sayi = scanner.nextInt();
            if (sayi > 0 && !(sayi % 2 == 0)) {
                toplamTek += sayi;
            } else if (sayi > 0 && sayi % 2 == 0) {
                continue;
            } else {
                break;
            }
        }
        System.out.println(toplamTek);

        while (true) {
            System.out.print("Bir sayı giriniz : ");
            sayi = scanner.nextInt();
            if (sayi % 4 == 0) {
                toplamCift += sayi;
            } else if (sayi % 2 == 0 && !(sayi % 4 == 0)) {
                continue;
            } else {
                break;
            }
        }
        System.out.println(toplamCift);
    }
}