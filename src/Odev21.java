//  Patika.dev Java 101 Ödev 21

/*
  Java ile kullanıcının girdiği değerler ile üslü sayı hesaplayan programı yazıyoruz.

  Ödev
  Java ile kullanıcının girdiği değerler ile üslü sayı hesaplayan programı
  "For Döngüsü" kullanarak yapınız.
*/

import java.util.Scanner;

public class Odev21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir taban sayı giriniz : ");
        int tabanSayi = scanner.nextInt();
        System.out.print("Bir sayı kuvveti giriniz : ");
        int sayiKuvveti = scanner.nextInt();

        // System.out.println((int) Math.pow(tabanSayi, sayiKuvveti));
        System.out.println(usHesapla(tabanSayi, sayiKuvveti));
    }

    public static String usHesapla (int taban, int us) {
        int toplam = 1, pozitifKuvvet;
        if (taban == 0) {
            toplam = 0;
        } else {
            if (us < 0) {
                pozitifKuvvet = -1 * us;
            } else {
                pozitifKuvvet =  us;
            }
            for (int i = 0; i < pozitifKuvvet; i++) {
                toplam *= taban;
            }
        }
        if (us < 0) {
            return taban + "^" + us + " = 1/" + toplam;
        } else {
            return taban + "^" + us + " = " + toplam;
        }
    }
}