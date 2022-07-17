package Java101;//  Patika.dev Java 101 Ödev 19

/*
  Java döngüler ile girilen sayıya kadar olan 2'nin kuvvetlerini
  ekrana yazdıran programı yazıyoruz.

  Ödev
  Java döngüler ile girilen sayıya kadar olan 4 ve 5'in kuvvetlerini
  ekrana yazdıran programı yazıyoruz.
*/

import java.util.Scanner;

public class Odev19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();

        for (int i = 0; i < sayi; i++) {
            System.out.println("2^" + i + " = " + (int)Math.pow(2, i));
        }

        for (int i = 0; i < sayi; i++) {
            System.out.println("4^" + i + " = " + (int)Math.pow(4, i) +
                    " ,  5^" + i + " = " + (int)Math.pow(5, i));
        }
    }
}