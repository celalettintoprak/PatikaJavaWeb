package Java101;// Patika.dev Java 101 Ödev 14

/*
  Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
  Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
  Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam fiyatını hesaplayın
  ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın;
*/
/*
  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı,
  yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya
  "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

  Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
  Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
  Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
  Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
*/
/*
  İpucu
  Normal Tutar = Mesafe * 0.10 = 1500 * 0.10 = 150 TL
  Yaş İndirimi = Normal Tutar * Yaş İndirim Oranı = 150 * 0.10= 15 TL
  İndirimli Tutar = Normal Tutar – Yaş İndirimi = 150 – 15 = 135 TL
  Gidiş Dönüş Bilet İndirimi = İndirimli Tutar * 0.20 = 135 * 0.20 = 27 TL
  Toplam Tutar = (135-27)* 2 = 216 TL
*/
/*
  Senaryolar
  Senaryo 1
  Mesafeyi km türünden giriniz : 1500
  Yaşınızı giriniz : 20
  Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): 2

  Toplam Tutar = 216 TL
*/
/*
  Senaryo 2
  Mesafeyi km türünden giriniz : -500
  Yaşınızı giriniz : 1
  Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): 77

  Hatalı Veri Girdiniz !
*/
/*
  Senaryo 3
  Mesafeyi km türünden giriniz : 200
  Yaşınızı giriniz : 35
  Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): 1

  Toplam Tutar = 20.0 TL
*/

import java.util.Scanner;

public class Odev14 {
    public static void main(String[] args) {
        float ucret = (float) 0.1, toplamFiyat;
        Scanner scanner = new Scanner(System.in);
        int mesafe = 0, yas = 0;
        String yolculukTipi = null;

        System.out.print("Mesafeyi km cinsinden giriniz: ");
        int mesafeInput = scanner.nextInt();
        if (mesafeInput < 1) {
            System.out.println("Hatalı veri girdiniz !");
        } else {
            mesafe = mesafeInput;
        }

        System.out.print("Yaş: ");
        int yasInput = scanner.nextInt();
        if (yasInput < 1) {
            System.out.println("Hatalı veri girdiniz !");
        } else {
            yas = yasInput;
        }

        System.out.print("Yolculuk Tipi (1- Tek Yön / 2- Gidiş-Dönüş): ");
        int yolculukInput = scanner.nextInt();
        if (yolculukInput == 1) {
            yolculukTipi = "Tek Yön";
        } else if (yolculukInput == 2) {
            yolculukTipi = "Gidiş-Dönüş";
        } else {
            System.out.println("Hatalı veri girdiniz !");
        }

        toplamFiyat = ucret * mesafe;

        if (yas < 12 && yas >= 1) {
            toplamFiyat *= 0.5;
        } else if (yas < 24 && yas >= 12) {
            toplamFiyat *= 0.9;
        } else if (yas >= 65) {
            toplamFiyat *= 0.7;
        }
        if (yolculukTipi != null && yolculukTipi.equals("Gidiş-Dönüş")) {
            toplamFiyat *= (2 * 0.8);
        }

        System.out.println(toplamFiyat + " TL");
    }
}