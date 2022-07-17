package Java101;//  Patika.dev Java 101 Ödev 20

/*
  Java ile faktöriyel hesaplayan program yazıyoruz.

  Ödev
  N elemanlı bir kümenin elemanları ile oluşturulacak r elemanlı farklı grupların sayısı
  n’in r’li kombinasyonu olarak adlandırılır. N’in r’li kombinasyonu C(n,r) şeklinde gösterilir.

  Java ile kombinasyon hesaplayan program yazınız.

  Kombinasyon formülü
  C(n,r) = n! / (r! * (n-r)!)
*/

import java.util.Scanner;

public class Odev20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");

        int sayi = scanner.nextInt();
        System.out.println(sayi + "! = " + faktoriyel(sayi));

        System.out.print("Bir sayı giriniz n = ");
        int n = scanner.nextInt();
        System.out.print("Bir sayı giriniz r = ");
        int r = scanner.nextInt();
        System.out.println("C("+ n + "," + r + ") = " + kombinasyon(n, r));
    }

    public static int faktoriyel (int sayi) {
        int toplam = 1;
        if (sayi > 0) {
            for (int i = 1; i <= sayi; i++) {
                toplam *= i;
            }
        }
        return toplam;
    }

    public static int kombinasyon (int n, int r) {
        return faktoriyel(n) / (faktoriyel(r) * faktoriyel(n - r));
    }
}