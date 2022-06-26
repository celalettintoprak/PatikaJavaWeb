//  Patika.dev Java 101 Ödev 32

/*
  Java ile bir sayının "Palindrom Sayı" olup olmadığını bulan bir program yapıyoruz.

  Palindrom Sayı Nedir ?
  Palindromik sayı, iki taraftan okunduğu zaman okunuş yönüyle aynı olan sayılardır.

  Örnek: 1, 4, 8, 99, 101, 363, 4004, 9889....
*/

import java.util.Scanner;

public class Odev32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int sayi = scanner.nextInt();

        if (sayi == palindrom(sayi)) {
            System.out.println(sayi + " sayısı palindromdur.");
        } else {
            System.out.println(sayi + " sayısı palindrom değildir.");
        }
    }

    public static int palindrom (int sayi) {
        sayi = Integer.parseInt(new StringBuilder().append(sayi).reverse().toString());
        return sayi;
    }
}