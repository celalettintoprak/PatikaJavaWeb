//  Patika.dev Java 101 Ödev 23

/*
  Java ile girilen sayının harmonik serisini bulan program yazınız.
*/

import java.util.Scanner;

public class Odev23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();
        double result = 0;
        for (double i = 1; i <= sayi; i++) {
            result += 1.0 / i;
        }

        System.out.println(result);
    }
}