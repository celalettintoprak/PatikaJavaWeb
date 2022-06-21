//  Patika.dev Java 101 Ödev 24

/*
  Java'da döngüler kullanılarak yıldızlar ile üçgen yapıyoruz.

  Ödev
  Java'da döngüler kullanarak yıldızlar ile elmas yapınız.

      *
     ***
    *****
   *******
  *********
   *******
    *****
     ***
      *
*/

import java.util.Scanner;

public class Odev24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();

        for (int i = 0; i <= sayi; i++) {
            for (int j = 0; j < (sayi - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}