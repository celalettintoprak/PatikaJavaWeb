package Java101;// Patika.dev Java 101 Ödev 6

/*
  Vücut Kitle İndeksi Hesaplama
  Java ile kullanıcıdan boy ve kilo değerlerini alıp bir değişkene atayın.
  Aşağıdaki formüle göre kullanıcının "Vücut Kitle İndeks" değerini hesaplayıp ekrana yazdırın.

  Formül
  Kilo (kg) / Boy(m) * Boy(m)

  Çıktısı
  Lütfen boyunuzu (metre cinsinde) giriniz : 1,72
  Lütfen kilonuzu giriniz : 105
  Vücut Kitle İndeksiniz : 35.49215792320173
 */

import java.util.Scanner;

public class Odev06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String decimalFormat = "%.2f";

        System.out.print("Lütfen boyunuzu (metre cinsinden virgül kullanarak) giriniz: ");
        float boy = input.nextFloat();
        System.out.print("Lütfen kilonuzu (kilogram cinsinden) giriniz: ");
        float kilo = input.nextFloat();

        System.out.println("Vücut Kitle Endeksiniz: " +
                String.format(decimalFormat, kilo / Math.pow(boy, 2)));
    }
}