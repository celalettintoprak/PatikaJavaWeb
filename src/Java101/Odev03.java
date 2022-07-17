package Java101;// Patika.dev Java 101 Ödev 3

/*
  Dik Üçgende Hipotenüs Bulan Program
  Java ile kullanıcıdan dik kenarlarının uzunluğunu alan
  ve hipotenüsü hesaplayan programı yazın.

  Ödev
  Üç kenar uzunluğunu kullanıcıdan aldığınız üçgenin alanını hesaplayan programı yazınız.

  Formül
  Üç𝑔𝑒𝑛𝑖𝑛 ç𝑒𝑣𝑟𝑒𝑠𝑖 = 2𝑢
  𝑢 = (a+b+c) / 2
  Alan * Alan = 𝑢 * (𝑢 − 𝑎)* (𝑢 − 𝑏) * (𝑢 − 𝑐)
 */

import java.util.Scanner;

public class Odev03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen üçgene ait iki dik kenar değerlerini giriniz: ");
        System.out.print("1. Ddik Kenar: ");
        int inputDeger1 = input.nextInt();
        System.out.print("2. Ddik Kenar: ");
        int inputDeger2 = input.nextInt();

        System.out.println("Hipotenüs: " + karekok(sayiUssuWhile(inputDeger1, 2) + sayiUssuFor(inputDeger2, 2)));

        alanHesapla3Kenar();
    }

    public static long sayiUssuWhile(int taban, int kuvvet) {
        long sonuc = 1;
        while (kuvvet != 0) {
            sonuc *= taban;
            --kuvvet;
        }
        return sonuc;
    }

    public static long sayiUssuFor(int taban, int kuvvet) {
        long sonuc = 1;
        for (; kuvvet != 0; --kuvvet) {
            sonuc *= taban;
        }
        return sonuc;
    }

    /**
    public static double sayiUssuPow(int taban, int kuvvet) {
        return Math.pow(taban, kuvvet);
    }
     */

    public static double karekok(double deger) {
        return Math.sqrt(deger);
    }

    public static void alanHesapla3Kenar() {
        int kenar1, kenar2, kenar3;
        double alan;
        Scanner input = new Scanner(System.in);

        System.out.print("1. Kenar: ");
        kenar1 = input.nextInt();
        System.out.print("2. Kenar: ");
        kenar2 = input.nextInt();
        System.out.print("3. Kenar: ");
        kenar3 = input.nextInt();

        if (kenar1 + kenar2 <= kenar3 || kenar2 + kenar3 <= kenar1 || kenar1 + kenar3 <= kenar2) {
            System.out.println("Girdiğiniz ölçülerle üçgen oluşturulamaz. Tekrar deneyiniz.");
        } else {
            int yarimCevre = (kenar1 + kenar2 + kenar3) / 2;
            alan = Math.sqrt((yarimCevre * (yarimCevre - kenar1) * (yarimCevre - kenar2) * (yarimCevre - kenar3)));
            System.out.println("Üçgenin alanı: " + alan + " birimkaredir.");
        }
    }
}