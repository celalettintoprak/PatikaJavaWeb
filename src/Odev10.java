// Patika.dev Java 101 Ödev 10

/*
  Dersler : Matematik, Fizik, Türkçe, Kimya, Müzik
  Geçme Notu : 55

  Ödev
  Eğer girilen ders notları 0 veya 100 arasında değil ise ortalamaya katılmasın.
 */

import java.util.Scanner;

public class Odev10 {
    public static void main(String[] args) {
        int sum = 0;
        String[] dersler = {"Matematik", "Fizik", "Kimya", "Türkçe", "Müzik"};
        int[] notlar = new int[dersler.length];

        for(int i = 0; i < notlar.length; i++) {
            notlar[i] = notEkle(dersler[i]);
        }

        for (int ders : notlar) {
            sum += ders;
        }

        System.out.println(dersler.length + " dersin not ortalaması: " + sum / dersler.length);
        System.out.println(sum / dersler.length >= 55 ? "Sınıfı Geçti" : "Sınıfta Kaldı");
    }

    public static int notEkle(String dersAdi) {
        Scanner input = new Scanner(System.in);
        int inputDers;

        while(true)
        {
            System.out.print(dersAdi + " ders notu: ");
            inputDers = input.nextInt();

            // Girilen notun 0-100 arasında bir değer olma durumu kontrol edilir.
            if (inputDers >= 0 && inputDers <=100) {
                System.out.println(dersAdi + " ders notu eklendi: " + inputDers);
                break;
            } else {
                System.out.println("Lütfen 0 ile 100 arasında değer giriniz.");
            }
        }
        return inputDers;
    }
}