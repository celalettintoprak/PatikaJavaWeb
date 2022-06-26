//  Patika.dev Java 101 Ödev 33

/*
  Java'da recursive metotlar ile fibonacci serisi bulan program yapıyoruz.
*/

import java.util.Scanner;

public class Odev33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();
        int[] fibonacciDizisi = new int[sayi];
        fibonacci(sayi, fibonacciDizisi);

        for (int i : fibonacciDizisi) {
            System.out.print(i + ",");
        }
    }

    public static void fibonacci (int sayi, int[] dizi) {
        dizi[0] = 1;
        dizi[1] = 1;
        for (int i = 2; i < sayi; i++) {
            dizi[i] = fib(i);
        }
    }

    public static int fib(int sayi) {
        if (sayi == 0 || sayi == 1) {
            return 1;
        }
        return fib(sayi - 1) + fib(sayi - 2);
    }
}