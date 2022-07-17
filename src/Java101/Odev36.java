package Java101;//  Patika.dev Java 101 Ödev 36

/*
  Java dilinde "Recursive" metot kullanarak, kullanıcıdan alınan
  sayının "Asal" sayı olup olmadığını bulan programı yazın.

  Senaryo
  Sayı Giriniz : 22
  22 sayısı ASAL değildir !

  Sayı Giriniz : 2
  2 sayısı ASALDIR !

  Sayı Giriniz : 39
  39 sayısı ASAL değildir !

  Sayı Giriniz : 17
  17 sayısı ASALDIR !
*/

import java.util.Scanner;

public class Odev36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();
        if (asalMi(sayi)) {
            System.out.println(sayi + " sayısı ASALDIR !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }
    }

    public static boolean asalMi (int sayi) {
        boolean asalMi = true;
        if (sayi <= 1) {
            asalMi = false;
        } else {
            for (int i = 2; i < sayi; i++) {
                if (sayi % i == 0) {
                    asalMi = false;
                    break;
                }
            }
        }
        return asalMi;
    }
}