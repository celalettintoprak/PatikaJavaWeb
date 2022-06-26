//  Patika.dev Java 101 Ödev 30

/*
  Java ile 1 - 100 arasındaki asal sayıları ekrana yazdıran programı yazınız.

  Senaryo
  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Odev30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. sayıyı giriniz : ");
        int sayi1 = scanner.nextInt();
        System.out.print("2. sayıyı giriniz : ");
        int sayi2 = scanner.nextInt();

        System.out.println(asalBulma(sayi1, sayi2));
    }

    public static List<String> asalBulma (int sayi1, int sayi2) {
        StringBuilder asalSayilar = new StringBuilder();
        for (int i = sayi1; i <= sayi2; i++) {
            if (asalSayi(i)) {
                asalSayilar.append(i).append(",");
            }
        }
        return Arrays.asList(asalSayilar.toString().split(","));
    }

    public static boolean asalSayi (int sayi) {
        boolean asalMi = true;
        if (sayi <= 1) {
            // System.out.println("Lütfen 1'den büyük pozitif bir tam sayı giriniz !");
            asalMi = false;
        } else {
            for (int i = 2; i < sayi; i++) {
                if (sayi % i == 0) {
                    asalMi = false;
                    break;
                }
            }
        }
        return asalMi;
    }
}