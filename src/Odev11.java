// Patika.dev Java 101 Ödev 11

/*
  Koşullar:
  Sıcaklık 5'dan küçük ise "Kayak" yapmayı öner.
  Sıcaklık 5 ve 15 arasında ise "Sinema" etkinliğini öner.
  Sıcaklık 15 ve 25 arasında ise "Piknik" etkinliğini öner.
  Sıcaklık 25'ten büyük ise "Yüzme" etkinliğini öner.

  Ödev
  Aynı örnek üzerinden if koşulları başka hangi şekilde
  oluşturulabilirdi farklı çözüm yolları bulunuz.
 */

import java.util.Scanner;

public class Odev11 {
    public static void main(String[] args) {
        int sicaklik;
        Scanner input = new Scanner(System.in);
        System.out.print("Sıcaklık giriniz: ");
        sicaklik = input.nextInt();

        if (sicaklik < 5) {
            System.out.println("Kayak yapabilirsiniz.");
        } else if (sicaklik >= 5 && sicaklik < 15) {
            System.out.println("Sinemaya gidebilirsiniz.");
        } else if (sicaklik >= 15 && sicaklik <= 25) {
            System.out.println("Pikniğe gidebilirsiniz.");
        } else if (sicaklik > 25) {
            System.out.println("Yüzmeye gidebilirsiniz.");
        } else {
            System.out.println("Geçersiz işlem...!");
        }
    }
}