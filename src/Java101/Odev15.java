package Java101;// Patika.dev Java 101 Ödev 15

/*
  Java ile kullanıcıdan doğum tarihini alıp Çin Zodyağı değerini hesaplayan program yazınız.
  Çin Zodyağı nedir?
  4000 bin yıldır kullanılan bir astroloji çeşididir Çin astrolojisi ve insanları
  12 değişik burç ve sembollerle tanımlar. Çin Zodyağı bu 12 burcun eşit aralıklarla
  (10 derece genişliğinde) sıralandığı bir hayvan halkasıdır ve yıldızlarla pek bir ilgisi yoktur.

  Çin Zodyağı nasıl hesaplanır?
  Çin zodyağı hesaplanırken kişinin doğum yılının 12 ile bölümünde kalana göre bulunur.

  Doğum Tarihi %12 = 0 ➜ Maymun
  Doğum Tarihi %12 = 1 ➜ Horoz
  Doğum Tarihi %12 = 2 ➜ Köpek
  Doğum Tarihi %12 = 3 ➜ Domuz
  Doğum Tarihi %12 = 4 ➜ Fare
  Doğum Tarihi %12 = 5 ➜ Öküz
  Doğum Tarihi %12 = 6 ➜ Kaplan
  Doğum Tarihi %12 = 7 ➜ Tavşan
  Doğum Tarihi %12 = 8 ➜ Ejderha
  Doğum Tarihi %12 = 9 ➜ Yılan
  Doğum Tarihi %12 = 10 ➜ At
  Doğum Tarihi %12 = 11 ➜ Koyun

  Senaryo
  Doğum Yılınızı Giriniz : 1990
  Çin Zodyağı Burcunuz : At
*/

import java.util.Scanner;

public class Odev15 {
    public static void main(String[] args) {
        int dogumYili;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Doğum Yılınızı Giriniz : ");
        dogumYili = scanner.nextInt();

        switch (dogumYili % 12) {
            case 0 -> System.out.println("Çin Zodyağı Burcunuz : " + "Maymun");
            case 1 -> System.out.println("Çin Zodyağı Burcunuz : " + "Horoz");
            case 2 -> System.out.println("Çin Zodyağı Burcunuz : " + "Köpek");
            case 3 -> System.out.println("Çin Zodyağı Burcunuz : " + "Domuz");
            case 4 -> System.out.println("Çin Zodyağı Burcunuz : " + "Fare");
            case 5 -> System.out.println("Çin Zodyağı Burcunuz : " + "Öküz");
            case 6 -> System.out.println("Çin Zodyağı Burcunuz : " + "Kaplan");
            case 7 -> System.out.println("Çin Zodyağı Burcunuz : " + "Tavşan");
            case 8 -> System.out.println("Çin Zodyağı Burcunuz : " + "Ejderha");
            case 9 -> System.out.println("Çin Zodyağı Burcunuz : " + "Yılan");
            case 10 -> System.out.println("Çin Zodyağı Burcunuz : " + "At");
            case 11 -> System.out.println("Çin Zodyağı Burcunuz : " + "Koyun");
        }
    }
}