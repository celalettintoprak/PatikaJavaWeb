//  Patika.dev Java 101 Ödev 22

/*
  Java döngüler ile sayının armstrong sayı olup olmadığını bulan programı yazıyoruz.

  Armstrong Sayı Nedir ?
  n haneli bir sayının basamaklarının n’inci üstlerinin toplamı,
  sayının kendisine eşitse, böyle sayılara Armstrong sayı denir.

  Örneğin 407 sayısını ele alalım. (4^3)+ (0^3)+(7^3) = 64+0+343 = 407
  sonucunu verir. Bu da 407 sayısının armstrong bir sayı olduğunu gösterir.

  1342 sayısına da bakalım. (1^4)+(3^4)+(4^4)+(2^4) =1+81+256+16=354
  sayısı 1342’ye eşit olmadığı için armstrong sayı olmaz.

  1634=1^4+6^4+3^4+4^4=1+1296+81+256=1634
  54748=5^5+4^5+7^5+4^5+8^5=3125+1024+16807+1024+32768=54748
*/

import java.util.Scanner;

public class Odev22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();

        armstrong(sayi);
        System.out.println(sayi + " sayısının basamakları toplamı : " + basamakToplama(sayi));
    }

    public static void armstrong (int sayi) {
        int sayiBolme = sayi;
        int length = String.valueOf(sayi).length();
        int toplam = 0;
        int[] basamaklar = new int[length];

        for (int i = 0; i < length; i++) {
            basamaklar[i] = sayiBolme % 10;
            sayiBolme = sayiBolme / 10;
        }

        for (int i : basamaklar) {
            toplam += Math.pow(i, length);
        }

        if (toplam == sayi) {
            System.out.println(sayi + " armstrong sayıdır.");
        } else {
            System.out.println(sayi + " armstrong sayı değildir.");
        }
    }

    public static int basamakToplama (int sayi) {
        int toplam = 0;
        int length = String.valueOf(sayi).length();
        for (int i = 0; i < length; i++) {
            toplam += sayi % 10;
            sayi = sayi / 10;
        }
        return toplam;
    }
}