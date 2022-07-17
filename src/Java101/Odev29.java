package Java101;//  Patika.dev Java 101 Ödev 29

/*
  Java ile basamak sayısının kullanıcıdan alınan ve döngüler kullanılarak,
  yıldızlar(*) ile ekrana ters üçgen çizen programı yazın.

  Örnek
  Basamak Sayısı : 10

  *******************
   *****************
    ***************
     *************
      ***********
       *********
        *******
         *****
          ***
           *
*/

import java.util.Scanner;

public class Odev29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();

        for (int i = sayi; i > 0; i--) {
            for (int j = (sayi - i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = (2 * i - 1); k >= 1; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}