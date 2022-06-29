//  Patika.dev Java 101 Ödev 37

/*
  Java dilinde kullanıcıdan alınan n değerine göre aşağıdaki
  kurala uyan döngü kullanmadan bir "Recursive" metot yazın.

  Kural : Girilen sayı 0 veya negatif olduğu yere kadar girilen sayıdan 5 rakamını çıkarın.
  Her çıkarma işlemi sırasında ekrana son değeri yazdırın. Sayı negatif veya 0 olduktan sonra
  tekrar 5 ekleyin. Yine her ekleme işleminde sayının son değerini ekrana yazdırın.

  Senaryolar
  N Sayısı : 16
  Çıktısı : 16 11 6 1 -4 1 6 11 16

  N Sayısı : 10
  Çıktısı : 10 5 0 5 10

  N Sayısı : 25
  Çıktısı : 25 20 15 10 5 0 5 10 15 20 25

  N Sayısı : 5
  Çıktısı : 5 0 5
*/

import java.util.Scanner;

public class Odev37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N Sayısı : ");
        int sayi = scanner.nextInt();
        System.out.print("Çıktısı : ");
        pozitifler(negatifler(sayi), sayi);
        // beser(sayi);
        // System.out.println(recur(sayi));
    }

    public static int negatifler(int sayi) {
        if (sayi <= 0){
            return sayi;
        } else {
            System.out.print(sayi + " ");
            return negatifler(sayi - 5);
        }
    }

    public static int pozitifler(int negatif, int sayi) {
        if (negatif > sayi){
            return negatif;
        } else {
            System.out.print(negatif + " ");
            return pozitifler(negatif + 5, sayi);
        }
    }

    public static void beser(int sayi) {
        if (sayi < 5) {
            System.out.println("5'ten büyük bir sayı giriniz.");
        } else {
            System.out.println("N sayısı : " + sayi);
            System.out.print("Çıktısı : ");
            int cikanSayi = 0;
            for (int i = sayi; i > -5; i -= 5) {
                System.out.print(i + " ");
                cikanSayi = i;
            }
            for (int i = cikanSayi + 5; i <= sayi; i += 5) {
                System.out.print(i + " ");
            }
        }
    }
    public static String recur(int sayi) {
        String sonuc = "";
        int cikanSayi;
        if (sayi > -5) {
            cikanSayi = sayi;
            System.out.print(cikanSayi + "/");
            sonuc += sayi + " " + recur(sayi - 5);
        }
        return sonuc;
    }
}