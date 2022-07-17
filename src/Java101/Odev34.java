package Java101;//  Patika.dev Java 101 Ödev 34

/*
  Gelişmiş Hesap Makinesi
  Java ile kullanıcın seçtiği işlemleri yapan hesap makinesi yapıyoruz.

  Hesap makinesinin fonksiyonları :
  1- Toplama İşlemi
  2- Çıkarma İşlemi
  3- Çarpma İşlemi
  4- Bölme işlemi
  5- Üslü Sayı Hesaplama
  6- Faktoriyel Hesaplama
  7- Mod Alma
  8- Dikdörtgen Alan ve Çevre Hesabı
*/

import java.util.Scanner;

public class Odev34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String menu = """
                1- Toplama İşlemi
                2- Çıkarma İşlemi
                3- Çarpma İşlemi
                4- Bölme İşlemi
                5- Sayının Üssü
                6- Faktöriyel
                7- Mod Alma
                8- Dikdörtgenin Alanı ve Çevresi
                Q- Çıkış
                """;

        char input;
        do {
            System.out.print(menu);
            System.out.print("\n" + "Yapmak istediğiniz işlemi seçiniz : ");
            input = scanner.next().trim().charAt(0);

            switch (input) {
                case 'q':
                case 'Q':
                    break;
                case '1':
                    System.out.println(dortislem("Toplama"));
                    break;
                case '2':
                    System.out.println(dortislem("Çıkarma"));
                    break;
                case '3':
                    System.out.println(dortislem("Çarpma"));
                    break;
                case '4':
                    System.out.println(dortislem("Bölme"));
                    break;
                case '5':
                    System.out.println(usHesapla());
                    break;
                case '6':
                    System.out.println(faktoriyel());
                    break;
                case '7':
                    System.out.println(modAlma());
                    break;
                case '8':
                    System.out.println(alanCevre());
                    break;
                default:
                    System.out.println("Geçersiz değer, tekrar deneyiniz.");
            }
        } while (input != 'q' && input != 'Q');
    }

    public static String dortislem(String islem) throws NumberFormatException {
        System.out.println(islem + " sonucunu hesaplamak için X'e basınız.");
        Scanner scanner = new Scanner(System.in);
        String input;
        int result = Integer.parseInt(scanner.next().trim());

        while (true) {
            input = scanner.next().trim();
            if (input.equals("x") || input.equals("X")) {
                break;
            } else {
                try {
                    int deger = Integer.parseInt(input.trim());
                    switch (islem) {
                        case "Toplama" -> result += deger;
                        case "Çıkarma" -> result -= deger;
                        case "Çarpma" -> result *= deger;
                        case "Bölme" -> result /= deger;
                    }
                }
                catch (Exception e) {
                    System.out.println("Lütfen bir tamsayı giriniz.");
                }
            }
        }
        return islem + " işlemi sonucu : " + result + "\n";
    }

    public static String usHesapla () {
        Scanner scanner = new Scanner(System.in);
        int toplam = 1, pozitifKuvvet;

        System.out.print("Taban sayısı : ");
        int taban = scanner.nextInt();
        System.out.print("Sayının kuvveti : ");
        int us = scanner.nextInt();

        if (taban == 0) {
            toplam = 0;
        } else {
            if (us < 0) {
                pozitifKuvvet = -1 * us;
            } else {
                pozitifKuvvet = us;
            }
            for (int i = 0; i < pozitifKuvvet; i++) {
                toplam *= taban;
            }
        }
        if (us < 0) {
            return taban + "^" + us + " = 1/" + toplam + "\n";
        } else {
            return taban + "^" + us + " = " + toplam + "\n";
        }
    }

    public static String faktoriyel () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir pozitif sayı giriniz : ");
        int sayi = scanner.nextInt();
        int toplam = 1;

        for (int i = 2; i <= sayi; i++) {
            toplam *= i;
        }
        return sayi + "! = " + toplam + "\n";
    }

    public static String modAlma () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();
        System.out.print("Mod değerini giriniz : ");
        int mod = scanner.nextInt();
        return sayi + " % " + mod + " = " + (sayi % mod) + "\n";
    }

    public static String alanCevre () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dikdörtgenin 1. kenarını giriniz : ");
        int kenar1 = scanner.nextInt();
        System.out.print("Dikdörtgenin 2. kenarını giriniz : ");
        int kenar2 = scanner.nextInt();

        return "Dikdörtgenin Çevresi : " + ((kenar1 + kenar2) * 2) + "\n" +
                "Dikdörtgenin Alanı : " + (kenar1 * kenar2) + "\n";
    }
}