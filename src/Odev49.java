//  Patika.dev Java 101 Ödev 49

/*
  Girilen kelimenin "Palindromik" olup olmadığı bulan bir program yazıyoruz.
  Kelime ile tersinden okunuşu aynı ise o kelime "Palindromik Kelime'dir".
  Örnek : ada , asa , kavak, kayak, teğet
*/

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Odev49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        palindromicControl(input);
    }

    public static String reverse(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(stringBuilder.append(input).reverse());
    }

    public static void palindromicControl(String input) {
        System.out.println("Input: " + input + "\n" +
                "Reversed: " + reverse(input) + "\n");

        if (input.equals(reverse(input))) {
            System.out.println("'" + input + "' kelimesi palindromiktir.");
        } else {
            System.out.println("'" + input + "' kelimesi palindromik değildir !");
        }
    }
}